int c;
StringBuilder response= new StringBuilder();

while ((c = bufferedReader.read()) != -1) {
    // Since c is an integer, cast it to a char.
    // If c isn't -1, it will be in the correct range of char.
    response.append( (char)c ) ;  
}
String result = response.toString();