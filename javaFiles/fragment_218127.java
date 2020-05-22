CsvParser file1Parser=new CsvParser(settings);
CsvParser file2Parser=new CsvParser(settings);

file1Parser.beginParsing(file1);
file2Parser.beginParsing(file2);

String[] rowOfParser1;
String[] rowOfParser2;

while((rowOfParser1 = file1Parser.parseNext()) != null){
    rowOfParser2 = file2Parser.parseNext();
    //do whatever you need to do with the rows.
}

//only need to call this if you are not reading both inputs entirely
file1Parser.stopParsing();
file2Parser.stopParsing();