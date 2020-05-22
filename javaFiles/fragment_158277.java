File moneyFile = null;

        Scanner moneyScan = null;

        int nickels = 0;
        int dimes = 0;
        int quarters = 0;
        int halfdollars = 0;        

        moneyFile = new File("Money.txt");

        try {
            moneyScan = new Scanner(moneyFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        String[] tempAr = new String[2];
        String temp = "";

        for(int i = 0; i<4; i++)
        {
            temp = moneyScan.nextLine();
            tempAr = temp.split("//");

            //match nickels
            if(tempAr[1].matches("nickels"))
            {
                nickels = Integer.parseInt(tempAr[0].trim());
                System.out.println(nickels);
            }

            //match dimes
            if(tempAr[1].matches("dimes"))
            {
                dimes = Integer.parseInt(tempAr[0].trim());
                System.out.println(dimes);
            }


            //match quarters
            if(tempAr[1].matches("quarters"))
            {
                quarters = Integer.parseInt(tempAr[0].trim());
                System.out.println(quarters);
            }

            //match halfdollars
            if(tempAr[1].matches("halfdollars"))
            {
                halfdollars = Integer.parseInt(tempAr[0].trim());
                System.out.println(halfdollars);
            }
        }