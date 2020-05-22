private static List<Person> readPeople(File file) {
    List<Person> people = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line = "";
      while((line = br.readLine()) != null) {
        String[] args = line.split(":");
        String country = args[0];
        String name = args[1];
        int age = Integer.parseInt(args[2]);
        String eyeColor = args[3];

        Person p = new Person(name, country, age, eyeColor);
        people.add(p);
      }
    } catch (IOException ex) {
      System.err.println(ex);
    } 
    return people;
}