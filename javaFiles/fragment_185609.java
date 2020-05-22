public class SaveRead implements Serializable
{
    private static final String PATH = "/Users/Konto/Documents/scores.txt";

    public void saveFile(HashMap<String, Integer> users)
            throws IOException
    {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(PATH))) {
            os.writeObject(users);
        }
    }

    public HashMap<String, Integer> readFile()
            throws ClassNotFoundException, IOException
    {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(PATH))) {
            return (HashMap<String, Integer>) is.readObject();
        }
    }

    public static void main(String... args)
            throws Exception
    {
        SaveRead xd = new SaveRead();

        // Populate and save our HashMap
        HashMap<String, Integer> users = new HashMap<>();
        users.put("David Minesote", 11);
        users.put("Sean Bright", 22);
        users.put("Tom Overflow", 33);

        xd.saveFile(users);

        // Read our HashMap back into memory and print it out
        HashMap<String, Integer> restored = xd.readFile();

        System.out.println(restored);
    }
}