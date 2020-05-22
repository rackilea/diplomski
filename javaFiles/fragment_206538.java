// Create object for pgBorders
        SectPr.PgBorders sectprpgborders = wmlObjectFactory.createSectPrPgBorders();             
            // Create object for top
            CTBorder border = wmlObjectFactory.createCTBorder(); 
            sectprpgborders.setTop(border); 
                border.setVal(org.docx4j.wml.STBorder.SINGLE);
                border.setSz( BigInteger.valueOf( 4) ); 
                border.setColor( "auto"); 
                border.setSpace( BigInteger.valueOf( 24) ); 
            // Create object for left
            CTBorder border2 = wmlObjectFactory.createCTBorder(); 
            sectprpgborders.setLeft(border2); 
                border2.setVal(org.docx4j.wml.STBorder.SINGLE);
                border2.setSz( BigInteger.valueOf( 4) ); 
                border2.setColor( "auto"); 
                border2.setSpace( BigInteger.valueOf( 24) ); 
            // Create object for bottom
            CTBorder border3 = wmlObjectFactory.createCTBorder(); 
            sectprpgborders.setBottom(border3); 
                border3.setVal(org.docx4j.wml.STBorder.SINGLE);
                border3.setSz( BigInteger.valueOf( 4) ); 
                border3.setColor( "auto"); 
                border3.setSpace( BigInteger.valueOf( 24) ); 
            // Create object for right
            CTBorder border4 = wmlObjectFactory.createCTBorder(); 
            sectprpgborders.setRight(border4); 
                border4.setVal(org.docx4j.wml.STBorder.SINGLE);
                border4.setSz( BigInteger.valueOf( 4) ); 
                border4.setColor( "auto"); 
                border4.setSpace( BigInteger.valueOf( 24) ); 
            sectprpgborders.setOffsetFrom(org.docx4j.wml.STPageBorderOffset.PAGE);