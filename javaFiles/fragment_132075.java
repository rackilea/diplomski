import java.io.*;

public class A {

     private Object mFoo;

     public A(Object foo) {
       mFoo = foo;
     }

     public Serializable getData() {
        String niceString = "Nice String";
        return new B(niceString);
     }

     public class B implements Serializable {
       private Object mBlob;

       public B (Object blob) {
          mBlob = blob;
       }

       public String toString() {
         return String.format("%s-%s-%s", getClass(), mBlob, mFoo);
       }

     }

     public static void main(String[] args)throws Exception {
       A a = new A("Have a nice Day");
       Serializable s  = a.getData();
       System.out.println("Before:" + s);
        ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
        ObjectOutputStream ostream = new ObjectOutputStream(bytesOut);
        ostream.writeObject(s);
        ostream.flush();
        ostream.close();
        ByteArrayInputStream bytesIn = new ByteArrayInputStream(bytesOut.toByteArray());
        ObjectInputStream istream = new ObjectInputStream(bytesIn);
        System.out.println("After:" + istream.readObject());
     }
}