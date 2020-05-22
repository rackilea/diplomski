public class Child {
    private String name;

    public Child(String name) {
        this.name = name;
        System.out.println("Constructing child named " + this.name);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public static void main(String[] args) {
        Child myChild = new Child("Penélope");
        System.out.println("My child is named " + myChild.getName());
        myChild.setName("María Elena");
        System.out.println("My child is now named " + myChild.getName());
    }
}