public void findAndRemplaceString(XWPFDocument doc,String champs[]){       
    for (XWPFParagraph p : doc.getParagraphs()) {       
        java.util.List<XWPFRun> runs = p.getRuns();
        if (runs != null) {            
            for (XWPFRun r : runs) {            
                String text = r.getText(0);            
                if (text != null && text.contains("P01") ) {
                    for (int i=0;i<champs.length;i++){
                        text = text.replace("P01","");
                        r.setText(text,0);   //Replace the old text 
                        r.setText(champs[i]);//add the new text
                        r.addBreak();        //new line
                    }
                }
            }
        }
    }
}