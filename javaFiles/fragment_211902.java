File f = new File("myfile.txt");
Scanner scn = new Scanner(f);
String s = ""; 
while(scn.hasNext()) {
    s=scn.next();
    try {
       Integer.parseInt(s); 
       //if the code made it to this line, s is an int, handle at as such 
    } catch(NumberFormatException e) {
       //s is a string, handle it as such
    }
}