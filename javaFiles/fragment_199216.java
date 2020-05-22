import java.util.ArrayList;
import java.util.Map;
import groovy.lang.Binding ;
import groovy.lang.GroovyShell ;

public class XMLParsing {
  public static void main(String[] args) {
    Map<String, ArrayList<String>> resultMap = getBookDetails("test.xml");
    System.out.println(resultMap);
  }

  public static Map<String, ArrayList<String>> getBookDetails( String scriptXml ) {
    Binding b = new Binding() ;
    b.setVariable( "xmlFile", scriptXml ) ;
    GroovyShell shell = new GroovyShell( b ) ;
    Object ret = shell.evaluate( "new XmlSlurper().parse( xmlFile ).book.findAll().collectEntries { [ (it.@id):[ it.name, it.author ] ] }" ) ;
    return (Map<String, ArrayList<String>>)ret ;
  }
}