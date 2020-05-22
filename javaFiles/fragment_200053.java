public static void createArr(Scanner klg, double [][] arr) {

    int i = 0;


    while (klg.hasNextLine()) {


        String line = klg.nextLine();
        String [] vals = line.split(" "); 

        arr[i] = new double [vals.length];
        int j = 0;

        for (String val : vals) {
            arr[i][j++] = Double.parseDouble(val);
        }

        i++;
    }

}