public static double[][] readFile(String fileName) {
     final double[][]data = new double[178][13];
      int x, y;
    try{
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    String line;
    x = 0; // Reset the line counter
    while((line = reader.readLine()) != null) { // Read a new line
        y=0; // Reset the column counter, since this is a new line 
        String[]values=line.split(",");
        for(String str:values){
            double str_double=Double.parseDouble(str);
            data[x][y]=str_double;
            System.out.print(data[x][y]+" ");
            ++y; // Advance to the next column
        }
        ++x; // Advance to the next line
        System.out.println();
    }
    reader.close();

    } catch (Exception e) {
        System.out.println("Aborting due to error: " + e);
    }    
     return data;    
 }