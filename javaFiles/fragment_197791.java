BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
double d;
try {
    d = Double.parseDouble( br.readLine() );
    list.add( d );
} catch( NumberFormatException nfe ) {
    System.out.println( "You did not enter a number!" );
}