public class MyHandler extends DefaultHandler {

private Map<String, MyCallbackAdapter> startLookup = new HashMap<String, MyCallbackAdapter>();
private Map<String, MyCallbackAdapter> endLookup = new HashMap<String, MyCallbackAdapter>();
private Stack<String> nodeStack = new Stack<String>();

public MyHandler() {
   // Initialize the lookup tables
   startLookup.put("Office", new MyCallbackAdapter() { 
      public void execute() { myOfficeStart() } 
    });

   endLookup.put("Office", new MyCallbackAdapter() { 
      public void execute() { myOfficeEnd() } 
    });
}

public void startElement(String namespaceURI, String localName,
        String qName, Attributes atts) {
  nodeStack.push(localName);

  MyCallbackAdapter callback = startLookup.get(localName);
  if (callback != null)
    callback.execute();
}

public void endElement(String namespaceURI, String localName, String qName)

  MyCallbackAdapter callback = endLookup.get(localName);
  if (callback != null)
    callback.execute();

  nodeStack.pop();
}

private void myOfficeStart() {
  // Do the stuff necessary for the "Office" start tag
}

private void myOfficeEnd() {
  // Do the stuff necessary for the "Office" end tag
}

//...