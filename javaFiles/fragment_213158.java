import java.io.IOException;
 import java.io.ObjectOutputStream;
 import java.io.OutputStream;

 public class ClaseAppendObjectStream extends ObjectOutputStream 
 {
      public ClaseAppendObjectStream(OutputStream os) throws IOException 
      {
          super(os);
      }

     protected void writeStreamHeader() throws IOException 
     {  
          reset();
     } 

 }