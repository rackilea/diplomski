ArrayList<List<String>> line = new ArrayList<>();
BufferedReader br = new BufferedReader(new FileReader(file));
CSVReaderHeaderAware csvReader = new CSVReaderHeaderAware(br);
int numLine = 0;
String[] values;
String endDate = null;
while ((values = csvReader.readNext()) != null) {
    ArrayList<String> data = new ArrayList<>();
    data.add(values[0]);
    data.add(values[1]);
    data.add(values[2]);
    data.add(values[3]);
    data.add(values[4]);
    data.add(values[5]);
    data.add(values[6]);
    line.add(data);

    if(numLine == 0){
        System.out.print("StartDate = "+ values[0]);
    }
    endDate = values[0];
    ++numLine;
}

if (endDate != null) { // Need to check null in case your CSV didn't have any rows
    System.out.println(" EndDate = " + endDate);
}