String escaped = StringEscapeUtils.escapeCsv(strXML);   

File file = new File("File.csv");
String arr[] = 
{
        "123456789&94859614357",
        escaped
};

FileWriter outputfile = null;
try 
{
        outputfile = new FileWriter(file,true);
        CSVWriter writer = new CSVWriter(outputfile,',', CSVWriter.NO_QUOTE_CHARACTER,CSVWriter.NO_ESCAPE_CHARACTER,System.getProperty("line.separator"));;
        writer.writeNext(arr);
        writer.close();
} 
catch (IOException e) 
{
        e.printStackTrace();
}