import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputFileParser
{
    public List<Entry> parse(String filename)
    {
        List<Entry> entries = new ArrayList<>();
        File f = new File(filename);
        try (BufferedReader reader = new BufferedReader(new FileReader(f));)
        {
            String line = null;
            while ((line = reader.readLine()) != null) 
            {
                String[] components = line.split(" ");
                entries.add(new Entry(components[0], Integer.parseInt(components[1]), components[2]));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return entries;
    }
}