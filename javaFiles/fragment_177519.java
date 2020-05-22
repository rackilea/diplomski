// See note later
String[] lines = new String[1000];

while (in.hasNextLine()) {
    String line = in.nextLine();
    lines[number] = line;
    number++;
}
// Get rid of subtract entirely... and only start off at "number"
// rather than lines.length, as there'll be a bunch of null elements
for (int i = number - 1; i >= 0; i--) {
    out.println(lines[i]);
}