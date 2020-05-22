FileReader fin = new FileReader(fileName);
Scanner src = new Scanner(fin);
ArrayList<String> lines = new ArrayList<String>();
src.useDelimiter(":");

while (src.hasNext()) {
    lines.add(src.nextLine());
    // replace above line with array
}
String[] lineArray = new String[lines.size()];
lines.toArray(lineArray);