Scanner scnr = new Scanner(fileLocation);
while (scnr.hasNextLine()) {
    String text = scnr.nextLine();
    System.out.println("text = " + text);
    String[] data = text.split(",")
    System.out.println("data = " + data.length);
    Students.add(new Student(data[0], data[1], data[2], data[3]));
}