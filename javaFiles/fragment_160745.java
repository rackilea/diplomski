BufferedReader br = new BufferedReader( new FileReader( "a.txt" ));
String line;
while(( line = br.readLine()) != null ) {
    if( line.contains( "001" )) sendToFile001( line );
    if( line.contains( "002" )) sendToFile002( line );
}
br.close();