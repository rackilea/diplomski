import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Test{
    private static String filename = "test";

    public static void main(String[] args) {
        writeToBinary (filename, "a", true);
        writeToBinary (filename, "b", true);
        writeToBinary (filename, "c", true);
        readFromBinaryFile (filename);
    }

    public static void writeToBinary (String filename, Object obj, boolean append){
        File file = new File (filename);
        ObjectOutputStream out = null;

        try{
            if (!file.exists () || !append) out = new ObjectOutputStream (new FileOutputStream (filename));
            else out = new AppendableObjectOutputStream (new FileOutputStream (filename, append));
            out.writeObject(obj);
            out.flush ();
        }catch (Exception e){
            e.printStackTrace ();
        }finally{
            try{
                if (out != null) out.close ();
            }catch (Exception e){
                e.printStackTrace ();
            }
        }
    }

    public static void readFromBinaryFile (String filename){
        File file = new File (filename);

        if (file.exists ()){
            ObjectInputStream ois = null;
            try{
                ois = new ObjectInputStream (new FileInputStream (filename));
                while (true){
                    String s = (String)ois.readObject ();
                    System.out.println (s);
                }
            }catch (EOFException e){

            }catch (Exception e){
                e.printStackTrace ();
            }finally{
                try{
                    if (ois != null) ois.close();
                }catch (IOException e){
                    e.printStackTrace ();
                }
            }
        }
    }

    private static class AppendableObjectOutputStream extends ObjectOutputStream {
          public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
          }

          @Override
          protected void writeStreamHeader() throws IOException {}
    }
}