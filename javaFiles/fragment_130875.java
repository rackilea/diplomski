public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException
{
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("data.txt"))))
    {
        Human human = new Human();
        human.setAge(21);
        human.setName("Test");
        System.out.println("Human : " + human);
        oos.writeObject(human);
        human.setName("Test123");
        oos.writeObject(human);
    }
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("data.txt"))))
    {
        Human newHuman1  = (Human)ois.readObject();
        System.out.println("newHuman1 :" + newHuman1);
        Human newHuman2  = (Human)ois.readObject();
        System.out.println("newHuman2 :" + newHuman2);
        System.out.println("Same object? " + (newHuman1 == newHuman2));
    }
}