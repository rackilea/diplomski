BufferedReader reader = new BufferedReader(new FileReader("Test.txt"));
String line;
while((line = reader.readLine()) != null) {
    String[] nums = line.split(" ");
    //get each num from nums and cast it to integer using Integer.parseInt()
}