public class PersonSaver {
    private final File file;

    public PersonSaver(File file) {
        this.file = file;
    }

    public void save(List<Person> people) throws FileNotFoundException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
            output.writeObject(people);
        } catch (IOException e) {
            //handle the exception you want to handle
            e.printStackTrace();
        }
    }
}