class Dog {

    int size;
    String breed;
    String name;

    void bark()
    {
        System.out.println("Wuff! Wuff!");
    }

    public static class DogTestDrive {

        public static void main(String []args)
        {
            Dog d = new Dog();
            d.size = 12;
            d.name = "pongy";
            d.bark();
            d.breed = "Labrodor";
        }
    }
}