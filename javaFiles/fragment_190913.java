String value = "";
System.out.println( "\nProvide " + label + ":" );
System.out.println( ">" );

while(value.equals("")) {

    try {
        value = input.readLine();
    }

    catch (IOException ex) { ex.printStackTrace(); }            
}
return value;