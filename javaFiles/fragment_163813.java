Document doc = textArea.getDocument();
Element root = doc.getDefaultRootElement();
Element element = root.getElement(2);
int start = element.getStartOffset();
int end = element.getEndOffset();
System.out.println(doc.getText(start, end - start));