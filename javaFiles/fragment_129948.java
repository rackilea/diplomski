public static void checkWeight(int startWeight, Number weight) {
        System.out.println("HERE?!");
        boolean run = true;
        System.out.println("HEHEHEH");
        while (true) {

            if (startWeight <= 50) {
                weight = startWeight;
                System.out.println("HERE");
                break; // or "return weight" maybe?
            }

            while (run) {
                int userWeightCheck = 
Integer.parseInt(JOptionPane.showInputDialog("Your cat's weight: "));
                if (userWeightCheck <= 50) {
                    System.out.println("OR HERE");
                    run = false;
                    startWeight = userWeightCheck;
                    break; // or "weight" maybe?
                } else {
                    System.out.println("Sorry, but that is not an acceptable 
input. Try again.");
                    continue;
                }
            }
        }

    }