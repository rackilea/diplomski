...
run = paragraph.createRun();  
run.setText("Page ");
paragraph.getCTP().addNewFldSimple().setInstr("PAGE \\* MERGEFORMAT");
run = paragraph.createRun();  
run.setText(" of ");
paragraph.getCTP().addNewFldSimple().setInstr("NUMPAGES \\* MERGEFORMAT");
...