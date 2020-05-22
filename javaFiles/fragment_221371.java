import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.io.*;

public class memoryHTML
{
    static String htmlLocation = "C:\\Users\\User\\";               
    static String fileName = "blah";                            // Just for demonstration, easily modified.
    static StringBuilder buildTmpHTML = new StringBuilder();
    static StringBuilder buildHTML = new StringBuilder();
    static String name = "John Doe";
    static String address = "42 University Dr., Somewhere, Someplace";
    static String phoneNumber = "(123) 456-7890";

    public static void main(String[] args)
    {
        // You can send it the full path with the filename. I split them up because I used this for multiple files.
        readHTML(htmlLocation, fileName);
        modifyHTML();

        System.out.println(buildHTML.toString());

        // You need to clear the StringBuilder Object or it will remain in memory and build on each run.
        buildTmpHTML.setLength(0);
        buildHTML.setLength(0);

        System.exit(0);
    }

    // Simply parse and build a StringBuilder for a temporary HTML file that will be modified in modifyHTML()
    public static void readHTML(String directory, String fileName)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(directory + fileName + ".html"));

            String line;
            while((line = br.readLine()) != null)
            {
                buildTmpHTML.append(line);
            }
            br.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }

    // Excellent method of parsing and modifying nodes in HTML files by @MarcoS at https://stackoverflow.com/a/6594828/1861357
    // It has its small problems, but it does the trick.
    public static void modifyHTML()
    {
        String htmld = buildTmpHTML.toString();
        Document doc = Jsoup.parse(htmld);

        final List<TextNode> nodesToChange = new ArrayList<TextNode>();

        NodeTraversor nd  = new NodeTraversor(new NodeVisitor() 
        {
          @Override
          public void tail(Node node, int depth) 
          {
            if (node instanceof TextNode) 
            {
              TextNode textNode = (TextNode) node;
              nodesToChange.add(textNode);
            }
          }

          @Override
          public void head(Node node, int depth) 
          {        
          }
        });

        nd.traverse(doc.body());

        for (TextNode textNode : nodesToChange) 
        {
          Node newNode = buildElementForText(textNode);
          textNode.replaceWith(newNode);
        }

        buildHTML.append(doc.html());
    }

    private static Node buildElementForText(TextNode textNode) 
      {
        String text = textNode.getWholeText();
        String[] words = text.trim().split(" ");
        Set<String> units = new HashSet<String>();
        for (String word : words) 
            units.add(word);

        String newText = text;
        for (String rpl : units) 
        {
            if(rpl.contains("Name"))
                newText = newText.replaceAll(rpl, "" + rpl + " " + name:));
            if(rpl.contains("Address") || rpl.contains("Residence"))
                newText = newText.replaceAll(rpl, "" + rpl + " " + address);
            if(rpl.contains("Phone-Number") || rpl.contains("PhoneNumber"))
                newText = newText.replaceAll(rpl, "" + rpl + " " + phoneNumber);
        }
        return new DataNode(newText, textNode.baseUri());
      }