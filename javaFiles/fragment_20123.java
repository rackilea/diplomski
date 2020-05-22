public static void main(String[] args) {
    int count = 0;
    Scanner in = new Scanner(System.in);
    int MAX_SIZE = 10;
    Person[] people = new Person[MAX_SIZE];

    System.out.println("Please enter the person's name or a blank line to quit");
    String line = in.nextLine();

    String[] names = line.split(" ");
    for (int i = 0; i < MAX_SIZE; i++) {
        Person p = new Person(names[i]);
        people[count++] = p;
    }
    in.close();

    Arrays.sort(people, 0, count);

    // printing out the first and last name(in alphabet order) of the entered names
    System.out.println("First: " + people[0]);
    System.out.println("Last: " + people[count - 1]);
}