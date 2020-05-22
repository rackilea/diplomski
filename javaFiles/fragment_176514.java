import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.parser.rtf.RTFParser;
import org.apache.tika.parser.txt.TXTParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;


public class TextParser {
public static void main(final String[] args) throws IOException,TikaException{
 //detecting the file type
 BodyContentHandler handler = new BodyContentHandler(-1);
 Metadata metadata = new Metadata();

 FileInputStream inputstream = new FileInputStream(new File("/Users/mydoc.rtf"));
 ParseContext pcontext = new ParseContext();

 //Text document parser
 TXTParser TXTParser = new TXTParser();
 try {
     TXTParser.parse(inputstream, handler, metadata,pcontext);

} catch (SAXException e) {

    e.printStackTrace();
} 
 String s=handler.toString();

Pattern pattern = Pattern.compile("(\\\\b\\\\f1\\\\fs24.+?\\\\par .+?)\\\\b\\\\f1\\\\fs24.*?\\{\\\\",Pattern.DOTALL);

Matcher matcher = pattern.matcher(s);
ArrayList<String> arr= new ArrayList<String>();

while (matcher.find()) {
       arr.add(matcher.group(1));
     }

 for(String name : arr){
     System.out.println("The array number is: "+arr.indexOf(name)+" \n\n "+name);
 }

 }
}