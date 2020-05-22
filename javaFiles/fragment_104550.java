org.docx4j.wml.ObjectFactory wmlObjectFactory = new org.docx4j.wml.ObjectFactory();

            // Create object for tab (wrapped in JAXBElement) 
            R.Tab rtab = wmlObjectFactory.createRTab(); 
            JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped = wmlObjectFactory.createRTab(rtab); 
            // Add it to the run... 
            run.getContent().add( rtabWrapped); 

            // Create object for br
            Br br = wmlObjectFactory.createBr();