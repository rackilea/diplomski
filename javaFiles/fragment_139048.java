JacksonXmlModule module = new JacksonXmlModule();
    module.setDefaultUseWrapper(false);
    XmlMapper xmlMapper = new XmlMapper(module);

    xmlMapper.readValue(
            "<condition type=\"NM-GD\" value=\"something\">no modification of guest details</condition>", Condition.class);