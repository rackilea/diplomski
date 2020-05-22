public class Test {
    public static void main(String[] args) {
        // here I have a few objects (test data)
        final Person person1 = new Person(1, "Foo", "Bar", 15);
        final Person person2 = new Person(2, "Aaa", "Bbb", 35);

        // I want to store them in a list to save the whole list
        final List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);

        // save 2 persons to DB (the method itself is below)
        Test.saveToDB(persons);

        // read from DB and just print to the console
        List<Person> dataFromDB = Test.readFromDB();
        System.out.println("\nData from database:");
        dataFromDB.forEach(System.out::println);

        // not let's imagine we need to update Foo user
        // we need to find it first, I know that this user has ID = 1
        // we could use firstName or lastName as a search criteria
        // but I assume those are not unique
        Optional<Person> fooBar = dataFromDB.stream().filter(person -> person.getId() == 1).findFirst();
        if (fooBar.isPresent()) {
            fooBar.get().setAge(25); // update
            fooBar.get().setFirstName("New Name"); // update 
        }

        System.out.println("\nData after update:");
        dataFromDB.forEach(System.out::println);

        // now we can save UPDATED data to the DB
        Test.saveToDB(dataFromDB);

        // after this line the XML file contains updated data !
        // just open the file and check 
    }

    // basically as in your example - this method just saves to the file
    // using XMLEncoder 
    public static void saveToDB(final List<Person> persons) {

        try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(
                new FileOutputStream("Database.xml")))) {

            // save data to database
            xmlEncoder.writeObject(persons);

            System.out.println("\nData saved successfully.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // the same API but for reading data from XML file
    public static List<Person> readFromDB() {
        final FileInputStream fis;
        try {
            fis = new FileInputStream(new File("Database.xml"));
            final XMLDecoder decoder = new XMLDecoder(fis);

            final List<Person> persons = (List<Person>) decoder.readObject();
            return persons;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}