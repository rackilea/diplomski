public static List<Person> loadPersons(String path) throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        List<Person> persons = new ArrayList<Person>();

        while((line = reader.readLine()) != null)
        {
            System.out.println("Adding " +line);
            persons.add(new Person(line));
        }

        return persons; 
    }