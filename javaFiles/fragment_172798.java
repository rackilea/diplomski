String dataLine;
Scanner in = new Scanner(f);
while (in.hasNextLine()) {
    dataLine = in.nextLine().trim();
    // Skip Blank Lines
    if (dataLine.equals("")) {
        continue;
    }
    String[] dataParts = dataLine.replace("Name : " , "").split(" Age : ");
    System.out.println("The Person's Name: " + dataParts[0] + System.lineSeparator() 
                     + "The Person's Age:  " + dataParts[1] + System.lineSeparator());
}