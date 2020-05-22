public void loadDataFromFile(String fileName) throws FileNotFoundException {
    try (Scanner in = new Scanner(new File(fileName))) {
        if (in.hasNextLine()) {
            in.nextLine(); // consume header
        }
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.isEmpty()) {
                continue; // skip empty lines.
            }
            int p = line.lastIndexOf(" ");
            String name = line.substring(0, p);
            int studentScore = Integer.parseInt(line.substring(p + 1));
            Student s = new Student(name, studentScore);
            student_list.add(s);
        }
    }
}