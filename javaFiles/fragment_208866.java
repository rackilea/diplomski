while (data.hasNextLine()) {
    String line = data.nextLine();
    String[] field = line.split(" ");
    totalVal += Double.parseDouble(field[1]);
    totalNums += 1;
}