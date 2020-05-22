try{
            inFile = new Scanner (new File("theWinner.dat"));
        }
     catch (FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }