public static double[][] readFile(String fileName) {
    ArrayList<double[]> numbers = new ArrayList<double[]>();        

    try {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = reader.readLine()) != null) { // Read a new line             
            int y=0; // Reset the column counter, since this is a new line 

            String[] values = line.split(",");

            if (values.length > 0) {
                double[] elements = new double[values.length];

                for (String str:values) {
                    double str_double;
                    try {
                        str_double = Double.parseDouble(str);
                        elements[y] = str_double;
                        System.out.print(elements[y] + " ");
                        ++y; // Advance to the next column
                    } catch (Exception e) {
                        continue; // Not a double, ignore
                    }
                }                   
                numbers.add(elements);                  
            } else {
                numbers.add(new double[0]); // No numbers read from the line
            }
            System.out.println();
        }                       
        reader.close();
    } catch (Exception e) {
        System.out.println("Aborting due to error: " + e);
    }

    return numbers.toArray(new double[0][0]);
}