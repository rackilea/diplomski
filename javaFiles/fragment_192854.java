List<List<String>> temps = new ArrayList<>();
Scanner dataScanner = new Scanner(dataFile);

while (dataScanner.hasNextLine()) {
    String[] data = dataScanner.nextLine().split(" ");
    temps.add(new ArrayList<>(Arrays.asList(data[0],data[1]));
}