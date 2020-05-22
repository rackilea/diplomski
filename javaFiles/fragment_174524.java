public class Main {

public static void main(String[] args) {
    List<Integer> lists = new ArrayList<>();
    List<Integer> readList = null;
    String filename = "save.dat";
    lists.add(1);
    lists.add(2);
    lists.add(3);

    //serialize
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
        oos.writeObject(lists);
    } catch (IOException e) {
        e.printStackTrace();
    }
    //don't need to close because ObjectOutputStream implement AutoCloseable interface

    //deserialize
    try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(filename))) {
        readList = (List<Integer>) oos.readObject();
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    //don't need to close because ObjectInputStream implement AutoCloseable interface


    //test
    if(!lists.equals(readList)) {
        System.err.println("error list saved is not the same as the one read");
    }
}

}