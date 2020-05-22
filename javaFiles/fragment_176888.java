import Settings.Person;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XmlSerializer 
{
    //File path to serialize to and deserialize from
    private static final String SERIALIZED_FILE_NAME = "yourSavePath.xml";
    //Insert person object and save as xml file to chosen filepath
    public static void Serialize(Person person)
    {
        try
        {
            FileOutputStream    os = new FileOutputStream(SERIALIZED_FILE_NAME);
            XMLEncoder          encoder = new XMLEncoder(os);
                                encoder.writeObject(person);
                                encoder.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    //Deserialize xml file into person object
    public static Person Deserialize()
    {
        try
        {
            FileInputStream os = new FileInputStream(SERIALIZED_FILE_NAME);
            XMLDecoder decoder = new XMLDecoder(os);
            Person p = (Person)decoder.readObject();
            decoder.close();
            return p;
        }
        catch(FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        return null;
    }
  }