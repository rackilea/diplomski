BufferedReader file = new BufferedReader(new FileReader(targetFile));
String line;
String input = "";
int count = 0;

while ((line = file.readLine()) != null) {
    if (count == 1) {
        line = line.replace(toUpdate, updated);
    }
    input += line + "\n";
    ++count;
}