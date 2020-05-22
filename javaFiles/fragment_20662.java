class FooState implements Serializable {
    Integer a, b, c; // Integer and String
    String d, e, f;  // also implement Serializable
}

class Foo {
    static FooState allMyState = new FooState();

    public static void main(String[] args) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(new File("myFile.data")))) {
            // no need to specify members individually
            oos.writeObject(allMyState);
        }
    }
}