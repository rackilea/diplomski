public void ReadFile(String inputfile) throws FileNotFoundException {
    arraylist = new ArrayList<Student>();
    File myFile = new File(inputfile);
    Scanner sc = new Scanner(myFile);

    while (sc.hasNextLine()) {
        try {
            String[] line = sc.nextLine().split(" ");

            arraylist.add(new Student(line[1], line[0], Integer.parseInt(line[2]), ...));
        } catch (Exception e) {
            System.out.println("Error of some kind...");
            continue; // maybe, I dunno.
        }
    }
}