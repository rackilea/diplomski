public static void main(final String[] args) throws IOException, ClassNotFoundException {
    final ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.out"));
    final Phonebook phonebook = new Phonebook();
    out.writeObject(phonebook);
    out.flush();
    out.close();

    final ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.out"));
    final Object o = in.readObject();
    System.out.println(o);
}