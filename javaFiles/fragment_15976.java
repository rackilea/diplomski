public void validate(String xml) {

    try {

        List<XmlValidationError> errors = new ArrayList<XmlValidationError>();
        EnvTesteDocument envTesteDocument = EnvTesteDocument.Factory.parse(xml);

        XmlOptions voptions = new XmlOptions();
        voptions.setValidateOnSet();
        voptions.setErrorListener(errors);

        if (envTesteDocument.getEnvTeste().getCFe().validate(voptions)) {
            return;
        }

        for (XmlValidationError error : errors) {
            ...
        }


    } catch (XMLInvalidException e) {}

}