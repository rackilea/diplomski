@Bean
public SwaggerSpringMvcPlugin yourPlugin() {
    ...
    plugin.directModelSubstitute(XMLGregorianCalendar.class, String.class)
    //OR this, depending on how you intend to use it and how you want
    // the serialized/deserialized types to appear on the swagger UI
    plugin.directModelSubstitute(XMLGregorianCalendar.class, Date.class)   
    ...
    return plugin
}