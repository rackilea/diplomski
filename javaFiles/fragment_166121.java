public class MyClass {

        public static synchronized void log1(String msg1, String msg2){
           log.writeln(msg1);
           log.writeln(msg2);
        }


        public static void log2(String msg1, String msg2){
           synchronized(MyClass.class){
              log.writeln(msg1);
              log.writeln(msg2);  
           }
        }
   }