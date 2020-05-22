private void replaceParagraph(String placeholder, String textToAdd, WordprocessingMLPackage template) {


        List<Object> paragraphs = getAllElementFromObject(template.getMainDocumentPart(), P.class);

        for (Object p : paragraphs) {  
            RangeFinder rt = new RangeFinder("CTBookmark", "CTMarkupRange");
            new TraversalUtil(p, rt);

            for (CTBookmark content : rt.getStarts()) {  

                if (content.getName().equals(placeholder)) {  

                    List<Object> theList = null;
                    if (content.getParent() instanceof P) {
                    theList = ((ContentAccessor)(content.getParent())).getContent();
                    } else {
                    continue; 
                    }

                    if (textToAdd == ""){ 

                        int index = theList.indexOf(content);
                        Object removed = theList.remove(index);
                    } else {
                    org.docx4j.wml.R run = factory.createR();
                    org.docx4j.wml.Text t2 = factory.createText();
                    run.getContent().add(t2);   
                    t2.setValue(textToAdd);
                    theList.add(0, run); 
                    break;
                    } 
                } 
            }  

        } 

    }