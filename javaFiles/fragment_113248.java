boolean valid = true;
    String shoppingCart = "";
    List<String[]> contents = new ArrayList<>();
    Scanner searchStockFile = new Scanner(stockFile);
    while (searchStockFile.hasNextLine()) {
        String[] current = searchStockFile.nextLine().split(",");
        contents.add(current);
    }
    String PH = "1";
    do {
        System.out.println("\n----------Add Items----------");
        System.out.print("Enter Item Codes: ");
        String itemCodes = userInput.nextLine();
        String itemCodesArray[] = itemCodes.split(" ");

        System.out.print("Enter Item Quantities: ");
        String quantities = userInput.nextLine();
        String quantityArray[] = quantities.split(" ");
        int[] quantityIntArray = new int[quantityArray.length];
        for (int i = 0; i < quantityArray.length; i++) {
            quantityIntArray[i] = Integer.parseInt(quantityArray[i]);
        }

        for (int i = 0; i < itemCodesArray.length; i++) {
            for (String[] elements : contents) {
                try {
                    if (itemCodesArray[i].equals(elements[0]) && Integer.parseInt(elements[2]) >= quantityIntArray[i]) {
                        shoppingCart += itemCodesArray[i] + "," + elements[1] + "," + elements[2] + "," + quantityIntArray[i] + "," + elements[3] + ".";
                    } else if (itemCodesArray[i].equals(elements[0]) && Integer.parseInt(elements[2]) < quantityIntArray[i]) {
                        System.out.println("The quantity of Item Code - " + itemCodesArray[i] + " - exceeds the current stock.");
                        valid = false;
                    }
                } catch (Exception e) {
                    System.out.println("The Item code you entered does not exist.");
                    valid = false;
                }
                if (!valid) {
                    System.exit(0);
                }
            }
        }

        while (true) {
            System.out.println("\n----------Purchase/Hire Items----------");
            System.out.print("1. Purchase Item\n2. Quit\nEnter Option Number: ");
            PH = userInput.nextLine();
            if (PH.equals("1")) {
                System.out.println("Purchasing..");
                break;
            } else if (PH.equals("2")) {
                System.out.println("Quitting..");
                System.exit(0);
            } else {
                System.out.println("Invalid Option chosen.\nPlease choose Options 1 or 2.");
            }
        }
    } while (PH.equals("1"));