@RequestMapping(value="/viewXSLT")
public ModelAndView viewXSLT(HttpServletRequest request,
        HttpServletResponse response) throws IOException {
    // builds absolute path of the XML file
    String xmlFile = "resources/citizens.xml";
    String contextPath = request.getServletContext().getRealPath("");
    String xmlFilePath = contextPath + File.separator + xmlFile;

    Source source = new StreamSource(new File(xmlFilePath));

    // adds the XML source file to the model so the XsltView can detect
    ModelAndView model = new ModelAndView("XSLTView");
    model.addObject("xmlSource", source);

    return model;
}