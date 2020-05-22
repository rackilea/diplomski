public class MyGame implements Serializable 
{ 
    private static void saveGame(ObjectType YourObject, String filePath) throws IOException 
    { 
        ObjectOutputStream outputStream = null; 
        try 
        { 
            outputStream = new ObjectOutputStream(new FileOutputStream(filePath)); 
            outputStream.writeObject(YourObject); 
        } 
        catch(FileNotFoundException ex) 
        { 
            ex.printStackTrace(); 
        } 
        catch(IOException ex) 
        { 
            ex.printStackTrace(); 
        } 
        finally 
        { 
            try 
            { 
                if(outputStream != null) 
                { 
                    outputStream.flush(); 
                    outputStream.close(); 
                } 
            } 
            catch(IOException ex) 
            { 
                ex.printStackTrace(); 
            } 
        } 
    } 

    public static ObjectType loadGame(String filePath) throws IOException 
    { 
        try 
        { 
            FileInputStream fileIn = new FileInputStream(filePath); 
            ObjectInputStream in = new ObjectInputStream(fileIn); 
            return (ObjectType) in.readObject(); 
        } 
        catch(FileNotFoundException ex) 
        { 
            ex.printStackTrace(); 
        } 
        catch(IOException ex) 
        { 
            ex.printStackTrace(); 
        } 
    } 
}