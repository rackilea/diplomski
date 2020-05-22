import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

  public static void printTree(Node doc) {
    if (doc == null) {
      System.out.println("Nothing to print!!");
      return;
    }
    try {
      System.out.println(doc.getNodeName() + "  " + doc.getNodeValue());
      NamedNodeMap cl = doc.getAttributes();
      for (int i = 0; i < cl.getLength(); i++) {
        Node node = cl.item(i);
        /*
        System.out.println("\t" + node.getNodeName() + " ->" + node.getNodeValue());
        //You don't need value
        */
        System.out.println("\t" + node.getNodeName());
      }
      NodeList nl = doc.getChildNodes();
      for (int i = 0; i < nl.getLength(); i++) {
        Node node = nl.item(i);
        printTree(node);
      }
    } catch (Throwable e) {
      System.out.println("Cannot print!! " + e.getMessage());
    }
  }

}