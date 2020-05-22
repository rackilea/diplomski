public static Pair<Integer, Integer> rowColumnCount(Scanner input1){
    int nrows=0;
    int ncolumns=0;


   while(input1.hasNextLine()){
       Scanner subinput1 = new Scanner(input1.nextLine());
       while(subinput1.hasNextInt()){
           subinput1.nextInt();
           ncolumns++;
       }

        nrows++;
    }

    System.out.print("Rows: " +nrows + "\n");
    System.out.print("Columns: " +ncolumns + "\n");

    return new Pair<Integer, Integer>(nrows, ncolumns);

    }//end rowCoulmnCount