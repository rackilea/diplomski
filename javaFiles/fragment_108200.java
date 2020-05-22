import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.rdf.model.Statement;

public class TestJena {

    public static void main(String[] args) {
        FileManager fManager = FileManager.get();
        fManager.addLocatorURL();
        Model model = fManager.loadModel("http://dbpedia.org/data/Ireland.rdf");

        Property geoProperty = 
        model. createProperty("http://www.w3.org/2003/01/geo/wgs84_pos#",
                                  "geometry");

        StmtIterator iter =
            model.listStatements(new SimpleSelector(null, geoProperty,(RDFNode) null)); 

        //Loop to traverse the statements that match the SimpleSelector
        while (iter.hasNext()) {
            Statement stmt = iter.nextStatement();
            if (stmt.getObject().isLiteral()) {
                Literal obj = (Literal) stmt.getObject();
                System.out.println("The geometry predicate value is " + 
                                                          obj.getString());
            }   
        }   
    }   

}