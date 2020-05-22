public static void main(String... args) {
    Vector<String[]> vector = new Vector<String[]>();
    vector.add(new String[] {"Hello", "World!"});

    System.out.println(vector.get(0)[1]); // prints World!
}