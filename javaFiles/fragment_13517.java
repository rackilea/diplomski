BufferedReader br = new BufferedReader (new FileReader ("num.txt"));
String line;

while( (line = br.readLine() ) != null) {
    System.out.printf(line);
}