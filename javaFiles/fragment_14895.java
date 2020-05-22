public class MyArt {

        public static void main(String argv[]) {
              MyArt m = new MyArt();
              m.amethod();
        }
        //you can very well have non-static method since you are 
        //calling it through MyArt object m
        public void amethod() { 

             int i=0; // REMOVED STATIC, otherwise program won't compile 
             System.out.println (i); // line 2, if not initialized compilation will fail where the variable is refrenced

        }
    }