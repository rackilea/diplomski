public static void main(String[] args) {

        boolean toContinue = false;  // True if user wants to play again.
        do {
            processString();
            System.out.print("Do you want enter another string?: ");
            toContinue = TextIO.getlnBoolean();
            } 
       while (toContinue == true);
}