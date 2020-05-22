public static int returnValue(){
    Scanner imp = new Scanner(System.in);
    boolean loP = true;
    int Nums =0; //declare them outside the try...catch block and give them a default value
    do {
        String num = imp.next();
        try {
           Nums = Integer.parseInt(num);
            loP = false;
        } catch (Exception e) {
            System.out.print("Please enter a number : ");
        }
    } while (loP);
    imp.close();
    }
    }