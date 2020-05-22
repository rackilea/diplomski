@RequestMapping(value = "/publicar", method = { RequestMethod.GET, RequestMethod.POST }, produces = MediaType.APPLICATION_XML_VALUE)
@ResponseBody
public ApiPubPortalPublicarOut publicar(@RequestParam(value = PARAM_XML) String xml, Locale locale) {
    //This object is my return, it creates an XML with the validation.
    ApiPubPortalPublicarOut xmlTaxOut = new ApiPubPortalPublicarOut();


    //validate incoming xml is empty
    if ((xml == null) || (xml.length() == 0)) {
        xmlTaxOut.setDescription("xml is Empty!");
        return xmlTaxOut;
    }else{
        try{
            //I transform the xml into an object
            JAXBContext jc = JAXBContext.newInstance(ApiPubPortalPublicarPortal.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            StreamSource streamSource = new StreamSource(new StringReader(xmlEntrada));
            JAXBElement<ApiPubPortalPublicarPortal> je = unmarshaller.unmarshal(streamSource, ApiPubPortalPublicarPortal.class);

            // Using concrete implementation of error interface
            BeanPropertyBindingResult result = new BeanPropertyBindingResult(je.getValue(), "apiPubPortal");


            //Here is the validation method.
            parsingPublicacion(je.getValue(), result, locale);
            if(result.hasErrors()){
                xmlTaxOut.setDescription(result.getAllErrors().toString());
                return xmlTaxOut;
            }
        }catch(Exception){
            xmlTaxOut.setDescription("Error parsing!");
            return xmlTaxOut;
        }
    }
}