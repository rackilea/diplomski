String fieldName = form.getXfa().getDatasetsNode().getFirstChild().getFirstChild().getFirstChild().getLocalName();
    String str = form.getXfa().getDatasetsNode().getFirstChild().getFirstChild().getFirstChild().getTextContent();
    String SiblingName = form.getXfa().getDatasetsNode().getFirstChild().getFirstChild().getFirstChild().getNextSibling().getLocalName();
    String SiblingValue = form.getXfa().getDatasetsNode().getFirstChild().getFirstChild().getFirstChild().getNextSibling().getTextContent();
    System.out.println("Field Name:"+fieldName);
    System.out.println("Field Value:"+str);
    System.out.println("Sibling Name:"+SiblingName);
    System.out.println("Sibling Value:"+SiblingValue);
    //Set the values back to form
    form.getXfa().getDatasetsNode().getFirstChild().getFirstChild().getFirstChild().setTextContent("Updated: Content for First Field");
    String updatedValue = form.getXfa().getDatasetsNode().getFirstChild().getFirstChild().getFirstChild().getTextContent();
    System.out.println("Field Value:"+updatedValue);