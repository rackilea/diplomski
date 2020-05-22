public class CubeVolume {
   private int width;
   private int depth;
   private int height;

   public static void main(String [] args) {
       if (args.length != 3) {
           throw new Exception("Width, height and depth are required arguments");
       }
       width = Integer.parseInt(args[0]);
       depth = Integer.parseInt(args[1]);
       height = Integer.parseInt(args[2]);

       // more stuff here
   }
}