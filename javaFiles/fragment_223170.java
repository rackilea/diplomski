public static void main(String[] args) throws IOException, ClassNotFoundException {
    // create a test ArrayList
    ArrayList<Integer> arr = new ArrayList<Integer>();
    for (int i = 0; i < 10; ++i)
        arr.add(i);

    // serialize ArrayList
    FileOutputStream fos = new FileOutputStream("test.ser");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(arr);
    oos.close();

    // desrialize ArrayList
    FileInputStream fis = new FileInputStream("test.ser");
    ObjectInputStream ois = new ObjectInputStream(fis);
    ArrayList<Integer> deser = (ArrayList<Integer>) ois.readObject();
    ois.close();

    System.out.println(deser.size());
    for (Integer element : deser)
        System.out.println(element);
}