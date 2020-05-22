public static void main (String[] args) throws java.lang.Exception
{
    /** I added this counter to keep track 
     *  of what iteration/line the loop currently is (see 2.)
     */ 
    int iteration = 0;
    for (int centerColumn = 1; centerColumn <= 128; centerColumn *=2){

        /** Here we changed the loop condition 
        *   from "j > 0" to "j > iteration"
        *   (So as iteration gets bigger, the loop runs less often)
        */
        for (int j = 8; j > iteration; j--) {
            System.out.printf("%7s", "");
        }
        for (int leftSide = 1; leftSide < centerColumn; leftSide*=2){
            /** This should be self explanatory. 
             *  You already did the same for rightSide.
             *  This will take care of 1.
             */
            System.out.printf("%7d",  leftSide );           
        }
        for (int rightSide = centerColumn; rightSide > 0; rightSide/=2){
           System.out.printf("%7d", rightSide);
        }
        /** Here we increment our counter with each iteration aka line that is printed */
        iteration++;
        System.out.println("");
    }
}