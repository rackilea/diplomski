while ((!in.hasNextInt())) 
    {
        System.out.print("You did not enter an integer number.  An integer number(whole numbers or counting numbers) is a    number like: 1, 2, 3...");
        System.out.print("Please enter an integer number: ");
        in.nextInt(); // use in.next() here
    }