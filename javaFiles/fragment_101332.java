BufferedReader br= new BufferedReader(new FileReader("yourfilename.txt"));
String dataRow=null;
string tempText="";
while ( (dataRow= br.readLine()) dataRow != null){
    if(dataRow.equalsIgnoreCase("[AXLE1RESULT]"){
        tempText+="[SomeText]";
        tempText+=System.getProperty("line.separator");
        tempText+="Something=0";
        tempText+=System.getProperty("line.separator");
        tempText+="Something=0";
        tempText+=System.getProperty("line.separator");
        tempText+="Something=0";
        tempText+=System.getProperty("line.separator");
    }
    tempText+=dataRow;
    tempText+=System.getProperty("line.separator");
}

FileWriter writer = new FileWriter("yourfilename.txt");
writer.append(tempText);    
writer.flush();
writer.close();