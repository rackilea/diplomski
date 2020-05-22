public class actionClass {
 public static xyObj cmdCenter(String cmdIF, int x, int y) {
     if(cmdIF.equalsIgnoreCase("NORTH") || cmdIF.equalsIgnoreCase("GO NORTH")){ 
      x++;
     }
     else if(cmdIF.equalsIgnoreCase("EAST") || cmdIF.equalsIgnoreCase("GO EAST")) {
      y++; 
      }
     else if(cmdIF.equalsIgnoreCase("SOUTH") || cmdIF.equalsIgnoreCase("GO SOUTH")) { 
      x--; 
      }
     else if(cmdIF.equalsIgnoreCase("WEST") || cmdIF.equalsIgnoreCase("GO WEST")) { 
      y--; 
      }
     else { System.out.println("You can't do that."); }

     //new xyObj setting x and y
     xyObj ret = new xyObj(x, y);
     //return it
     return ret;
 }

}