public static void valid(String s, int max) { 
    while(true) {
        if(!sc.hasNextInt()) { //this is the same as sc.hasNextInt() == false
            System.out.println("That is not correct. Try again:");
            sc.nextLine();
            continue; //restart the loop again
        } else {
            int value = sc.nextInt();
            if(value > max || value <= 0) {
                System.out.println("That is not correct. Try again:");
                sc.nextLine();
                continue; //restart the loop from the top - important!
            } else {
                extendedValidation(value, s);
                return;
            }
        }
    }
}