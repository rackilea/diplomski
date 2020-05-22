StringBuilder builder = new StringBuilder();
    while ((line = bufferedReader.readLine()) != null) {
        builder.append(line);
    }
String[] lineArray= builder.toString().split("/");
for(String line: lineArray){
    String[] dataArray = line.split(";");
    tableModel.addRow(dataArray);
}