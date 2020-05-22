import lotus.domino.*;
import java.util.Vector;
import java.util.Enumeration;
public class JavaAgent extends AgentBase {
  public void NotesMain() {
    try {
      Session session = getSession();
      AgentContext agentContext = session.getAgentContext();
      // (Your code goes here) 
      Database db = agentContext.getCurrentDatabase();
      DocumentCollection dc = db.getAllDocuments();
      Document doc = dc.getFirstDocument();
      boolean saveFlag = false;
      while (doc != null) {
        RichTextItem body = 
        (RichTextItem)doc.getFirstItem("Body");
        System.out.println(doc.getItemValueString("Subject"));
        Vector v = body.getEmbeddedObjects();
        Enumeration e = v.elements();
        while (e.hasMoreElements()) {
          EmbeddedObject eo = (EmbeddedObject)e.nextElement();
          if (eo.getType() == EmbeddedObject.EMBED_ATTACHMENT) {
            eo.extractFile("c:\\extracts\\" + eo.getSource());
            eo.remove();
            saveFlag = true;
            }
        }
        if (saveFlag) {
          doc.save(true, true);
          saveFlag = false;
          }
        doc = dc.getNextDocument();
      }
    } catch(NotesException e) {
      System.out.println(e.id + " " + e.text);
      e.printStackTrace();
    }
  }
}