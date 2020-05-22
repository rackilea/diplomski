public class Assignment1 {

    public static int isEven() {
        Scanner keyboard = new Scanner(System.in);
        int num = keyboard.nextInt();

        num = num % 2; // divide by 2 and get a remainder.
        switch (num) {
            case 0: //case 0 means if number equal to zero
                System.out.println("The Number is Even no Remainders");
                break;
            case 1: // case 1 means if number equal to one
                System.out.println("The Number is not even so there are Remainders");
                break;
            default: // if no one match if not a valid.
                System.out.println("Please input a valid number, Thank you.");

        }//switch
        /*pull number from user
        //store in num
        //if even print message num is even
        //else print message not an even number
         * This is the remainder of my psuedcode notes to remind me how my
         * mind was flowing
         */
        return num;

    } //isEven

    public static void main(String args[]) {
        Assignment1.isEven();

    }//
}