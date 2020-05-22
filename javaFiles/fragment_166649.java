public void insertUpdate(DocumentEvent documentEvent) {
    if (documentEvent.getDocument()== field.getDocument()){
        System.out.println("event caused by field");
    }
    else if (documentEvent.getDocument()== field2.getDocument()){
        System.out.println("event caused by field2");
    }
}