// Create object for r
        R r = wmlObjectFactory.createR(); 
        p.getContent().add( r); 
            // Create object for t (wrapped in JAXBElement) 
            Text text = wmlObjectFactory.createText(); 
            JAXBElement<org.docx4j.wml.Text> textWrapped = wmlObjectFactory.createRT(text); 
            r.getContent().add( textWrapped); 
                text.setValue( "Paragraph"); 
        // Create object for r
        R r2 = wmlObjectFactory.createR(); 
        p.getContent().add( r2); 
            // Create object for tab (wrapped in JAXBElement) 
            R.Tab rtab = wmlObjectFactory.createRTab(); 
            JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped = wmlObjectFactory.createRTab(rtab); 
            r2.getContent().add( rtabWrapped); 
            // Create object for t (wrapped in JAXBElement) 
            Text text2 = wmlObjectFactory.createText(); 
            JAXBElement<org.docx4j.wml.Text> textWrapped2 = wmlObjectFactory.createRT(text2); 
            r2.getContent().add( textWrapped2); 
                text2.setValue( "that was a tab");