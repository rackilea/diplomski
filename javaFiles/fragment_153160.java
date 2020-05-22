public class MyApp {

    public static void main(String[] args) {
        List<Animal> list = new ArrayList<>();
        list.add(new Animal("British Bulldog", "12345", "UK"));
        list.add(new Animal("Boston Terrier", "12346", "USA"));
        list.add(new Animal("German Shepherd", "12347", "Germany"));
        // this is a for-each loop but basically you just need
        // to get an item from the list, list.get(i) would suffice
        for (Animal a: list) {
            System.out.println(a.getName());
        }
    }

}