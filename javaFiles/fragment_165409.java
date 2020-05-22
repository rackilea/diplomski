do {
    StringBuilder name = new StringBuilder();
    int ch;
    while((ch = origReader.read()) >= 0 && ch != ',' && ch >= ' ') {
       name.append((char) ch);
    }
    test.add(name.toString());
} while(origReader.readLine() != null);