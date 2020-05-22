public class Addr
 {
     // All the stuff from above
     public Addr(byte[] buffer)
     {
         foo = buffer[0];
         bar = someFunctionThatGetsTheEndiannessRight(buffer[1], buffer[2]);
     }
 }