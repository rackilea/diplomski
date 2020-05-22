...    
Player player2 = new Player(-1, -1, -1, -1, -1);
System.out.println("Player 2: ");
 try {
                number1 = Integer.parseInt(keyin.nextLine());
                number2 = Integer.parseInt(keyin.nextLine());
                number3 = Integer.parseInt(keyin.nextLine());
                number4 = Integer.parseInt(keyin.nextLine());
                number5 = Integer.parseInt(keyin.nextLine());
                System.out.println("");
    }
    //Code will go to this block when user entered something other than integers
    catch(NumberFormatException e) {
        System.out.println("Done accepting bets from player2");
    }
    ...