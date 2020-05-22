org.docx4j.wml.ObjectFactory wmlObjectFactory = new org.docx4j.wml.ObjectFactory();
            // Create object for rPr
            RPr rpr = wmlObjectFactory.createRPr(); 
            r.setRPr(rpr); 
                // Create object for strike
                BooleanDefaultTrue booleandefaulttrue2 = wmlObjectFactory.createBooleanDefaultTrue(); 
                rpr.setStrike(booleandefaulttrue2);