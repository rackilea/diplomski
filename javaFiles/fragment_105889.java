if(menuOption == 1 || menuOption == 2 || menuOption == 3 || menuOption == 4){
            //arraysize
            System.out.println("How many values are in the arrays?");
            arraysize = input.nextInt();
            //1st array
            array1 = new double[arraysize];
            System.out.println("Enter the values in the first array, separated by spaces: ");
            input.nextLine();       //consume whitespaces
            String number = input.nextLine();
            for(int i = 0; i<arraysize; i++)
                array1[i] = Integer.parseInt(number.split(" ")[i]);  //split the string at the whitespaces and convert it to an int
            //2nd array
            array2 = new double[arraysize];
            System.out.println("Enter the values in the secound array, separated by spaces: ");
            number = input.nextLine();
            for(int i = 0; i<arraysize; i++)
                array2[i] = Integer.parseInt(number.split(" ")[i]);
        }