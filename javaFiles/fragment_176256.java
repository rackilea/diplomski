@RequestMapping(value = "/publicar", method = { RequestMethod.GET, RequestMethod.POST }, produces = MediaType.APPLICATION_XML_VALUE)
@ResponseBody
public ApiPubPortalPublicarOut publicar(@RequestParam(value = PARAM_XML) String xml,
                                        BindingResult result, Locale locale) {
            //This object is my return, it creates an XML with the validation.
            ApiPubPortalPublicarOut xmlTaxOut = new ApiPubPortalPublicarOut();
            // Use BindingResult in places of erros


        }