int counter = 0;
while (reader.hasNextLine()) {
    String line = reader.nextLine();
    System.out.println(line);
    counter++;
}