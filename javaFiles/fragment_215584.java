String fileName = "input.txt";
File file = new File(fileName);
Scanner scanner = new Scanner(file);

ArrayList<Byte> covertDataList= new ArrayList<>();
while(scanner.hasNextLine()){
    String line = scanner.nextLine(); // the line should be just a number
    covertDataList.add(Byte.parseByte(line)); // no substring needed
}