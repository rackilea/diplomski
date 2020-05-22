ObjectFactory factory = Context.getWmlObjectFactory();


    CTSimpleField ctSimple = factory.createCTSimpleField();
    ctSimple.setInstr(" MergeField fieldValue \\* MERGEFORMAT ");

    RPr RPr = factory.createRPr();
    RPr.setNoProof(new BooleanDefaultTrue());

    Text t = factory.createText();
    t.setValue("fieldValue");

    R run = factory.createR();
    run.getRunContent().add(RPr);
    run.getRunContent().add(t);

    ctSimple.getParagraphContent().add(run);

    JAXBElement<CTSimpleField> fldSimple = factory
            .createPFldSimple(ctSimple);

    // P
    P para = factory.createP();
    para.getParagraphContent().add(fldSimple);


    Body body = factory.createBody();
    body.getEGBlockLevelElts().add(para);
    wordMLPackage.getMainDocumentPart().addObject(body);