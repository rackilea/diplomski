import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class ExportToXml {

public Note createNote() {

    Note container = new Note();
    container.setBody("Don't forget me this weekend!");
    container.setFrom("Jeni");
    container.setHeading("Reminder");
    container.setTo("Tony");

    return container;
}

public static void main(String[] args){

    final XStream xstream = new XStream(new StaxDriver());
    xstream.alias("MyCustomNote", Note.class);
    xstream.aliasField("toAddress", Note.class,"to");
    xstream.aliasField("fromName", Note.class,"from");
    xstream.aliasField("heading", Note.class,"heading");
    xstream.aliasField("output", Note.class,"body");

    ExportToXml export = new ExportToXml();

    Note firstNote = export.createNote();

    final File file = new File("D:\\export.xml");
    BufferedOutputStream stdout;
    try {

        stdout = new BufferedOutputStream(new FileOutputStream(file));
    } catch (final FileNotFoundException e) {
        throw new RuntimeException(e);
    }
    xstream.marshal(firstNote, new PrettyPrintWriter(
            new OutputStreamWriter(stdout)));

}