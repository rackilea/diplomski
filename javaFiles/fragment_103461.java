for (int i = 0 ; i< Array.length; i++){
        Scanner s2= new Scanner(transfer.nextLine())
        boolean hasLong= s2.hasNextLong();
        //consume the input
        s2.next();
        \\next is a string so skip it
        s2.next();
        boolean hasInt= s2.hasNextInt();
        //consume the input
        s2.next();
        s2.next();
        boolean hasDouble=s2.hasNextDouble();
        s2.next();
        boolean hasInt2= s2.hasNextInt();
        //consume the input
        s2.next();
        boolean allTrue=hasLong&&hasInt&&hasDouble&&hasInt2;
        if(!allTrue){
        //print the line number so you can check where the issue is in the file
        System.out.println("error on line: "+i);
        //print the values of the booleans if you want
        }
        s2.close();
        }
    transfer.close();