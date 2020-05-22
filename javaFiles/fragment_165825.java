// number of values in file
        int totalNumValues = 0;
        // total sum
        double totalSum = 0;

        while(salesDataFile.hasNextLine()){
            String line = salesDataFile.nextLine();

            ArrayList<Double> salesData = new ArrayList<Double>();

            // total values in this line
            int numValuesInLine = 0;
            // sum in this line
            double sumLine = 0;

            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while(scanner.hasNextDouble()){
                  double value = scanner.nextDouble();
                  sumLine = sumLine + value;
                  numValuesInLine++;
                  totalNumValues++;
                  totalSum = totalSum + value;
            }
            scanner.close();

            System.out.println(salesData);
        }