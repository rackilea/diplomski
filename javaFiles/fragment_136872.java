import java.util.*;
import java.io.*;

/** 
 * Usage sample serializing SomeClass instance 
 */
public class ToStringSample {

    public static void main( String [] args )  throws IOException,
                                                      ClassNotFoundException {
        String string = toString( new SomeClass() );
        System.out.println(" Encoded serialized version " );
        System.out.println( string );
        SomeClass some = ( SomeClass ) fromString( string );
        System.out.println( "\n\nReconstituted object");
        System.out.println( some );


    }

    /** Read the object from Base64 string. */
   private static Object fromString( String s ) throws IOException ,
                                                       ClassNotFoundException {
        byte [] data = Base64.getDecoder().decode( s );
        ObjectInputStream ois = new ObjectInputStream( 
                                        new ByteArrayInputStream(  data ) );
        Object o  = ois.readObject();
        ois.close();
        return o;
   }

    /** Write the object to a Base64 string. */
    private static String toString( Serializable o ) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( o );
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray()); 
    }
}

/** Test subject. A very simple class. */ 
class SomeClass implements Serializable {

    private final static long serialVersionUID = 1; // See Nick's comment below

    int i    = Integer.MAX_VALUE;
    String s = "ABCDEFGHIJKLMNOP";
    Double d = new Double( -1.0 );
    public String toString(){
        return  "SomeClass instance says: Don't worry, " 
              + "I'm healthy. Look, my data is i = " + i  
              + ", s = " + s + ", d = " + d;
    }
}