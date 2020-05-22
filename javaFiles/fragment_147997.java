public class Animals {
    private String userName;
    private Scanner scanner = new Scanner(System.in);

    // This list will hold all your dogs
    private List<Dog> dogs;

    public Animals() {
        // Add the dogs to the list on the class constructor
        dogs = new ArrayList<>();
        dogs.add(new Dog("Oscar", "German Shepherd", "No one", 2));
        dogs.add(new Dog("Sheeba", "BullDog", "No one", 4));
    }

    public void myAnimal () {
        // Display dog names (this could be in a separate method)
        System.out.println("Please Choose a Dog:");
        for(Dog dog : dogs) {
            System.out.println(dog.getName());
        }

        // Find the chosen dog (this could be in a separate method)
        String chooseDog = scanner.nextLine();
        for(Dog dog : dogs) {
            if(dog.getName().equals(chooseDog)) {
                // Deal with the chosen dog
                dealWithDog(dog);
            }
        }

        // Do it all over again
        myAnimal();
    }

    private void dealWithDog(Dog dog) {
        System.out.println(dog.getInfo());
        System.out.println("Adopt "+dog.getName()+"? | Yes | No");

        String adoptDog = scanner.nextLine();
        if (adoptDog.equals("Yes")) {
            dog.setOwner(userName);

            System.out.println("Change "+dog.getName()+"'s name? | Yes | No");
            String changeName = scanner.nextLine();
            if (changeName.equals("Yes")) {
                System.out.println("New Name");
                String newName = scanner.nextLine();
                dog.setName(newName);
            } else if (changeName.equals("No")) {
                System.out.println(dog.getInfo());
            }
        }
    }

    public void username() {
        System.out.println("Your Name?");
        userName = scanner.nextLine();
        System.out.println("Hello " + userName);
    }
}