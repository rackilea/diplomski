in = new BufferedReader(new FileReader("D:/sample.txt")); // <-- added ':'
String str;   
int lineCount = 0;
while ((str = in.readLine()) != null) {  
  process(str, lineCount++);
}