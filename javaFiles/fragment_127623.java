import java.io.*;
class ElectronicDevice  { 
  public int i = 0;
  protected ElectronicDevice() 
  {
       System.out.println("ed "); 
  }
}
class Mp3player extends ElectronicDevice implements Serializable {
   int j =0;
   Mp3player() 
   { 
       System.out.println("mp "); 
   }
}
class MiniPlayer extends Mp3player {
  MiniPlayer()
  { 
      System.out.println("mini "); 
  }
 public static void main(String[] args) {
      MiniPlayer m = new MiniPlayer();
      m.i = 30;
      m.j = 40;
      try {
             System.out.println("i value before serialization: "+m.i);//prints 30
             System.out.println("i value before serialization: "+m.j);//prints 40
             FileOutputStream fos = new FileOutputStream("dev.txt");
             ObjectOutputStream os = new ObjectOutputStream(fos);
             os.writeObject(m); os.close();

             FileInputStream fis = new FileInputStream("dev.txt");
             ObjectInputStream is = new ObjectInputStream(fis);
             MiniPlayer m2 = (MiniPlayer) is.readObject(); 
             is.close();
             System.out.println("i value after serialization: "+m2.i);//prints o
             System.out.println("j value after serialization: "+m2.j);//prints 40
             System.out.println();
        } catch (Exception x) {
            x.printStackTrace();
            System.out.print("x "); 
       }
   }
 }