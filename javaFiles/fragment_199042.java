public class PersonSaver {
    private final File file;

    public PersonSaver(File file) {
        this.file = file;
    }

    public void save(List<Person> people) throws FileNotFoundException, IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
            output.writeObject(people);
        } catch (IOException e) {
            /*Some code to clear some data or to handle the 
              exception but still throw an exception higher*/
            throw e;
        }
    }
}