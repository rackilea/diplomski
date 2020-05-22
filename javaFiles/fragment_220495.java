public static void main(String[] args) {

        String name, address;

        Scanner kevs = new Scanner(System.in);

        System.out.println("Enter your fullname. Including Middle Initial, Separated by spaces.");

        //get the full name
        name = kevs.nextLine();

        System.out.println("\nEnter your address. Separated by spaces.");
        //get the address
        address = kevs.nextLine();

        String initials = "";
        //get the first letter of the name and add it to our initial string
        char c = name.charAt(0);
        initials += c;
        for (int i = 0; i < name.length(); i++) {
            char letter = name.charAt(i);
            // if we find a space, select the first letter after it until the end
            if (letter == ' ') {
                initials += name.charAt(i + 1);
            }

        }
        String addressNum = "";
        //this bool is so that we only select characters up to the first space
        boolean finished = false;
        for (int i = 0; i < address.length(); i++) {
            if (!finished) {
                char num = address.charAt(i);
                if (num != ' ') {
                    //add characters to the address string until there is a space
                    addressNum += num;
                } else // we found the first space so we are now finished
                {
                    finished = true;
                }
            } else //we are finished so leave the loop
            {
                break;
            }
        }
        //concatenate the strings
        System.out.println(initials + addressNum);

    }