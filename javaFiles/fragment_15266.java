//use string builder to avoid unnecessary string creation.
StringBuilder builder = new StringBuilder();
int charsRead = -1;
char[] chars = new char[100];
do{
    charsRead = reader.read(chars,0,chars.length);
    //if we have valid chars, append them to end of string.
    if(charsRead>0)
        builder.append(chars,0,charsRead);
}while(charsRead>0);
String stringReadFromReader = builder.toString();
System.out.println("String read = "+stringReadFromReader);