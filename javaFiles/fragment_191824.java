List<ConverterHelper> converters
       = Engine.getInstance().getRegisteredConverters();
for (ConverterHelper converterHelper : converters) {
    System.out.println("- " + converterHelper);
}

/* This will print this in your case:
   - org.restlet.ext.gson.GsonConverter@2085ce5a
   - org.restlet.engine.converter.DefaultConverter@30ae8764
   - org.restlet.engine.converter.StatusInfoHtmlConverter@123acf34
*/