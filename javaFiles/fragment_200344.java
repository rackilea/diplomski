public class YourContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {      
        //This method is called by the container on start up
        //Your code should look something like this:
       Source xsltSource = new StreamSource(xsltFile);
       TransformerFactory transFact = TransformerFactory.newInstance();
       Templates cachedXSLT = transFact.newTemplates(xsltSource);
       Transformer trans = cachedXSLT.newTransformer();

       ServletContext context = sce.getServletContext();
       context.setAttribute("cashedXSLT", cachedXSLT);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {        
    }   

}