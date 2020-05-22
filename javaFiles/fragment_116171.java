public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);
  List<Student> al = new ArrayList<Student>();
  try {
    System.out.println("Enter student names [firstname lastname], CTRL-D to stop.");
    String line;
    while ((line = scanner.nextLine()) != null) {
      if (line != null) {
        line = line.trim();
        String[] names = line.split(" ");
        if (names.length == 2) {
          al.add(new Student(names));
        }
      }
    }
  } finally {
    for (Student student : al) {
      System.out.println(student);
    }
    scanner.close();
  }
}