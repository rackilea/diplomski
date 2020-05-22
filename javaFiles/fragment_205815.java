System.out.print("Input the number of persons: ");
Scanner scanner = new Scanner(System.in);
int noOfP = scanner.nextInt();
scanner.nextLine();

Person[] person = new Person[noOfP];

String name;
int age;
for(int i = 0; i < person.length; i++){
    System.out.println("Input name for guest: ");
    name = scanner.nextLine();
    System.out.println("Input age for guest: ");
    age = scanner.nextInt();
    scanner.nextLine();

    person[i] = new Person(name,age);
}