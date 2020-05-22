public User getUser() {
    Scanner input = new Scanner(System.in);

    User user = new User();

    System.out.println("Name:");
    String name = input.next();

    System.out.println("Age");
    int age = input.nextInt();

    System.out.println("Sex");
    double sex= input.next();

    System.out.println("Location:");
    String location= input.next();

    System.out.println("Subscribe:");
    boolean subscribe= input.nextBoolean();
    user.set(name, age, sex, location); // user object would hold this information
    user.set(subscribe);

    return user;
}