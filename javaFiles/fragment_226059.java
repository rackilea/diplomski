BufferedReader b = new BufferedReader(new FileReader(source));
String line = b.readLine();
StringBuilder build = new StringBuilder();
while(line != null && !line.equals("Detail")){
    line = b.readLine();
}
line = b.readLine();
while(line != null){
    build.append(line);
    build.append('\n');
    line = b.readLine();
}
System.out.println(build.toString());
Reader toBeParsed = new StringReader(build.toString());