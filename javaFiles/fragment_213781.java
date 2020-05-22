FileReader fin = new FileReader(fileName);
Scanner src = new Scanner(fin);

src.useDelimiter(":");

while (src.hasNext()) {
    System.out.println(src.next());
    // replace above line with array
}