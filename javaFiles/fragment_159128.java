try (Scanner sc = new Scanner(System.in)) {
    System.out.print("Name: ");        
    while (sc.hasNextLine()) {

        String name = sc.nextLine();
        System.out.println("Name is \"" + name + "\"");
        System.out.print("Name: ");
    }
}