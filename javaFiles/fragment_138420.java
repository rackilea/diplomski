public org.docx4j.wml.P addParaAtIndex(MainDocumentPart mdp, String simpleText, int index) {

    org.docx4j.wml.ObjectFactory factory = Context.getWmlObjectFactory();
    org.docx4j.wml.P  para = factory.createP();

    if (simpleText!=null) {
        org.docx4j.wml.Text  t = factory.createText();
        t.setValue(simpleText);

        org.docx4j.wml.R  run = factory.createR();
        run.getContent().add(t); 

        para.getContent().add(run); 
    }

    mdp.getContent().add(index, para);

    return para;
}