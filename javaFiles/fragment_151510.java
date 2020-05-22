try {

String sCurrentLine;
StringBuilder sb = new StringBuilder();// Declare a string builder object.
br = new BufferedReader(new FileReader("C:\\Users\\home\\Desktop\\Test\\Sample.txt"));
int i = 0;
while ((sCurrentLine = br.readLine()) != null) {
    if(i>0) {
        sb.append(" and ");
    }
    sb.append(sCurrentLine);
    System.out.println("Line No." + i + " " + sCurrentLine);
    i++;
}
System.out.println("Appended output " + sb.toString());