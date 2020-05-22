public class Serializer 
{   
    private String filename;

    // pass in "entries.bin"
    public Serializer(String filename) {
        this.filename = filename;
    }

    public void append(Object target) {
        // readfile will return at least empty arraylist
        ArrayList entries = readFile();
        entries.add(target);
        serialize(entries);
    }

    public void serialize(ArrayList entries)
    {   
        FileOutputStream fileOut = null;
        ObjectOutputStream objOut = null;
        try 
        {
            fileOut = new FileOutputStream(filename);
            objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(entries);
            objOut.close();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    //Reads the file and returns all entries in a list
    public ArrayList deserialize () 
    {
        ArrayList persistedEntries = new ArrayList<>();

        FileInputStream fileIn = null;
        ObjectInputStream objIn = null;
        try
        {
            fileIn = new FileInputStream(filename);
            objIn = new ObjectInputStream(fileIn);

            Object result = objIn.readObject();
            if (!(result instanceof ArrayList)) {
                // read object is not an arraylist
            }

            persistedEntries = (ArrayList) objIn.readObject();
            objIn.close();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }

        return persistedEntries;
    }   
}