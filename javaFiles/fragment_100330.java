BufferedReader file = new BufferedReader(new FileReader(targetFile));
String line;
StringBuilder input = new StringBuilder();
int count = 0;

while ((line = file.readLine()) != null) {
    if (count == 1) {
        line = line.replace(toUpdate, updated);
    }
    input.append(line).append('\n');
    ++count;
}