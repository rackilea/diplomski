public static Sld createSld() throws JAXBException {

    ObjectFactory factory = Context.getpmlObjectFactory(); 
    Sld sld = factory.createSld();
    sld.setCSld( 
            (CommonSlideData)XmlUtils.unmarshalString(COMMON_SLIDE_DATA, Context.jcPML, CommonSlideData.class) );

    return sld;     
}