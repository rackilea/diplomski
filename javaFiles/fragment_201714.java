import gate.*;
import gate.creole.ANNIEConstants;
import gate.util.persistence.PersistenceManager;
import java.io.File;
import java.util.*;

public class AnnieNerExample {

    public static void main(String[] args) throws Exception {
        Gate.setGateHome(new File("C:\\Program Files\\GATE_Developer_8.1"));
        Gate.init();

        LanguageAnalyser controller = (LanguageAnalyser) PersistenceManager
                .loadObjectFromFile(new File(new File(Gate.getPluginsHome(),
                        ANNIEConstants.PLUGIN_DIR), ANNIEConstants.DEFAULT_FILE));

        Corpus corpus = Factory.newCorpus("corpus");
        Document document = Factory.newDocument(
                "Michael Jordan is a professor at the University of California, Berkeley.");
        corpus.add(document); controller.setCorpus(corpus); 
        controller.execute();

        document.getAnnotations().get(new HashSet<>(Arrays.asList("Person", "Organization", "Location")))
            .forEach(a -> System.err.format("%s - \"%s\" [%d to %d]\n", 
                    a.getType(), Utils.stringFor(document, a),
                    a.getStartNode().getOffset(), a.getEndNode().getOffset()));

        //Don't forget to release GATE resources 
        Factory.deleteResource(document); Factory.deleteResource(corpus); Factory.deleteResource(controller);
    }
}