public class Client {
    List<String> test = new myListContainer<>(Arrays.asList("Janek",
        "Bartek", "Stefan", "Horacy", "Jakub", "Antoni"));

    boolean bl = test.iterator().hasNext();  //ok, 
    Iterator iter = test.iterator();

    public void foo() {
        while (iter.hasNext()) { // here it will work!

        }
    }
}