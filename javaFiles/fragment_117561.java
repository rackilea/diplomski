public class Die {
    /** This program simulates rolling a die */
    public static void main(String[] args) {

       int die;   // The number on the die.

       for(int i = 0; i < 500; i++){
           die = (int)(Math.random()*6 + 1);
           System.out.println (die);    
       }    
    }  // end main()
}  // end class