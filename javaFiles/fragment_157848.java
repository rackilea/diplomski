public class actionClass {
  public static int[] cmdCenter(String cmdIF, int x, int y) {
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

 //New array, first position x, second position y
 int[] res = {x,y};
 //Return it
 return res;
}

}