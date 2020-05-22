WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();

        DocumentSettingsPart dsp = wordMLPackage.getMainDocumentPart().getDocumentSettingsPart();
        CTSettings settings = Context.getWmlObjectFactory().createCTSettings();
        BooleanDefaultTrue val = new BooleanDefaultTrue();
        val.setVal(true);

        CTCompat compat = Context.getWmlObjectFactory().createCTCompat();
        compat.setDoNotExpandShiftReturn(val);
        settings.setCompat(compat);
        dsp.setJaxbElement(settings);
        wordMLPackage.getMainDocumentPart().addTargetPart(dsp);