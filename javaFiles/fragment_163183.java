boolean firstLine = true;
String[] readLineCSVs = csvFile.split("\n");
for (String readLineCSV : readLineCSVs) {
    rows++;
    if (firstLine) {
        firstLine = false;
    } else {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Readdata rd = new Readdata();
        String[] csvData = readLineCSV.split(csvSplitBy);
        int count =0;

        try{
        while(csvData[count++]!=null){
            System.out.println(count);
        }
        System.out.println(csvData[0]);
        System.out.println(csvData[1]);
        System.out.println(csvData[2]);
        System.out.println(csvData[3]);
        System.out.println(csvData[4]);
        System.out.println(csvData[5]);
        System.out.println(csvData[6]);
        System.out.println(csvData[7]);
        System.out.println(csvData[8]);
        System.out.println(csvData[9]);
      }
      catch (ArrayIndexOutOfBoundsException e){
                    e.printStackTrace();
            }
    }