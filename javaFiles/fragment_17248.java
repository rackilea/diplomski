import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.xmlbeam.XBProjector;
import org.xmlbeam.XBProjector.Flags;
import org.xmlbeam.annotation.XBWrite;
import org.xmlbeam.dom.DOMAccess;

@SuppressWarnings("javadoc")
public class DuplicateNode {

    // Projection to embed some nodes into an "ALL" element
    public interface AllNodes {
        @XBWrite("./*")
        AllNodes setNodes(List<DOMAccess> nodes);
    };

    // Projection for the output document
    public interface OutputProjection {
        @XBWrite("/ROOT/*")
        void setNodes(List<AllNodes> nodes);
    };

    public static void main(String[] args) throws IOException {
        // Create the projector we will use to project the data
        XBProjector projector = new XBProjector(Flags.TO_STRING_RENDERS_XML);

        //Read all nodes from input document
        List<DOMAccess> nodes =projector.io().url("res://example.xml").evalXPath("/ROOT/*").asListOf(DOMAccess.class);

        // Create some copies
        List<AllNodes> newNodeList = new LinkedList<AllNodes>();
        newNodeList.add(projector.projectEmptyElement("ALL",AllNodes.class).setNodes(nodes));
        newNodeList.add(projector.projectEmptyElement("ALL",AllNodes.class).setNodes(nodes));
        //...

        // Create an output projection that will take the copied nodes
        OutputProjection outputProjection = projector.projectEmptyDocument(OutputProjection.class);

        // set nodes to the output projection
        outputProjection.setNodes(newNodeList);

        // print it out (or write to file, stream,...)
        System.out.println(outputProjection);
    }
}