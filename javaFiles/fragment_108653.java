while (scnr.hasNextLine()) {
    String text = scnr.nextLine();
    System.out.println(text);

    String data[] = text.split(",", -1);
    System.out.println(Arrays.toString(data));
    Students.add(new Student(data[0], data[1], data[2], data[3]));
}