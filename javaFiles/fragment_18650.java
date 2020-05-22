FileOutputStream fos = new FileOutputStream("awesomefile.csv"); 
OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
CSVWriter writer = new CSVWriter(osw);
...
String[] row = {
    "123", 
    "John", 
    "Smith", 
    "39", 
    "I said \"Hey, I am 5'10\".\""
};
writer.writeNext(row);
...
writer.close();
osw.close();
os.close();