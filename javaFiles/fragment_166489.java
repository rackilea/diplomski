// generatePdfReport single node
@RequestMapping(method = RequestMethod.GET, value = "/report/{id}")
public ModelAndView generatePdfReport(@PathVariable(value = "id") Long id, ModelAndView modelAndView)
        throws JRException {

    LOG.info("--------------generate PDF report----------");

    Map<String, Object> parameterMap = new HashMap<String, Object>();

    java.util.List<Node> nodeList = new ArrayList<Node>();
    nodeList.add(nodeService.getOne(id));

    JRDataSource JRdataSource = new JRBeanCollectionDataSource(nodeList);

    parameterMap.put("datasource", JRdataSource);

    // pdfReport bean has ben declared in the spring configuration
    modelAndView = new ModelAndView("nodesReport_PDF", parameterMap);

    return modelAndView;

}