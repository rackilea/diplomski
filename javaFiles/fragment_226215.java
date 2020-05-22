BufferedReader br = new BufferedReader( new FileReader(fileName) );
String str;
while ((str = br.readLine()) != null) {
    Manual manual = new Manual( str );
    manualList.add( manual );
}
br.close();