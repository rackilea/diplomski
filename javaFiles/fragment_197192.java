// Create object for r
        R r = wmlObjectFactory.createR(); 
        p.getContent().add( r); 
            // Create object for t (wrapped in JAXBElement) 
            Text text = wmlObjectFactory.createText(); 
            JAXBElement<org.docx4j.wml.Text> textWrapped = wmlObjectFactory.createRT(text); 
            r.getContent().add( textWrapped); 
                text.setValue( "Paragraph"); 
        // Create object for r
        R r3 = wmlObjectFactory.createR(); 
        p.getContent().add( r3); 
            // Create object for t (wrapped in JAXBElement) 
            Text text3 = wmlObjectFactory.createText(); 
            JAXBElement<org.docx4j.wml.Text> textWrapped3 = wmlObjectFactory.createRT(text3); 
            r3.getContent().add( textWrapped3); 
                text3.setValue( "      "); 
                text3.setSpace( "preserve"); 
        // Create object for r
        R r5 = wmlObjectFactory.createR(); 
        p.getContent().add( r5); 
            // Create object for t (wrapped in JAXBElement) 
            Text text5 = wmlObjectFactory.createText(); 
            JAXBElement<org.docx4j.wml.Text> textWrapped5 = wmlObjectFactory.createRT(text5); 
            r5.getContent().add( textWrapped5); 
                text5.setValue( "that was some space.");