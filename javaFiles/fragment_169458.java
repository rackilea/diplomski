public static String getElementXpath(DOMElement elt){
    String path = ""; 
    try {
      for (; elt != null && elt.ELEMENT_NODE == elt.getNodeType(); elt = (DOMElement) elt.getParentNode()){
        int idx = getElementIdx(elt);
        String xname = elt.getTagName();    
        if (idx > 1) {
           xname += "[" + idx + "]";
        }
        path = "/" + xname + path;  
        System.out.println("Inside: " + path);  // **1**
      }
    } catch(Exception e) {
        // unhides any exception thrown inside the for loop
        e.printStackTrace();   
    } finally {
        // forces a final print of "path", even if a runtime exception was raised
        System.out.println("Outside: " + path); // **2**
    }
    return path;                            
}