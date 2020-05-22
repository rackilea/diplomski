int ch;
while ((ch = fileReader.read()) != -1) {
    char c = (char)ch;
    System.out.println(c);
    ...
}