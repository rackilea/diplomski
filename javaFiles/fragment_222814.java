import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.reasoner.rulesys.GenericRuleReasoner;
import com.hp.hpl.jena.reasoner.rulesys.Rule;
import com.hp.hpl.jena.util.PrintUtil;

public class TypeMappingExample {
    public static void main(String[] args) throws IOException {
        PrintUtil.registerPrefix( "n", "urn:ex:n/" );
        PrintUtil.registerPrefix( "m", "urn:ex:m/" );
        String content = "\n" +
                "@prefix n: <urn:ex:n/>.\n" +
                "@prefix m: <urn:ex:m/>.\n" +
                "@prefix x: <urn:ex:x/>" +
                "\n" +
                "x:a a n:Person.\n" +
                "x:b a m:Person.\n" +
                "";
        Model model = ModelFactory.createDefaultModel();
        try ( InputStream in = new ByteArrayInputStream( content.getBytes() )) {
            model.read( in, null, "TTL" );
        }
        String rule = "\n" +
                "[strConcat(n:,'(.*)',?nprefix),\n" +
                " strConcat(m:,'(.*)',?mprefix),\n" +
                " (?x rdf:type ?ntype), strConcat(?ntype,?ntypestr),\n" +
                " (?y rdf:type ?mtype), strConcat(?mtype,?mtypestr)," +
                " regex(?ntypestr,?nprefix,?nsuffix),\n" +
                " regex(?mtypestr,?mprefix,?msuffix),\n" +
                " equal(?nsuffix,?msuffix)\n" +
                " -> \n" +
                "(?x rdf:type ?mtype)]";
        Reasoner reasoner = new GenericRuleReasoner( Rule.parseRules( rule ));
        InfModel imodel = ModelFactory.createInfModel( reasoner, model );
        imodel.write( System.out, "TTL" );
    }
}