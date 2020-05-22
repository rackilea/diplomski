import javax.xml.parsers.DocumentBuilderFactory;
import net.sf.saxon.s9api.*;
import org.w3c.dom.Document;

...

  Document merge(Document context, Document other) throws Exception
  {
    Processor processor = new Processor(false);
    XQueryExecutable executable = processor.newXQueryCompiler().compile(
      "declare variable $other external; element {node-name(*)} {*/*, $other/*/*}");
    XQueryEvaluator evaluator = executable.load();    
    DocumentBuilder db = processor.newDocumentBuilder();
    evaluator.setContextItem(db.wrap(context));
    evaluator.setExternalVariable(new QName("other"), db.wrap(other));
    Document doc =
      DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    processor.writeXdmValue(evaluator.evaluate(), new DOMDestination(doc));
    return doc;
  }