String line;
while (infile.hasNextLine()){
    line = infile.nextLine();
    String data[] = line.split("\\s+");
    state = data[0];
    population = Integer.parseInt(data[1]);
}