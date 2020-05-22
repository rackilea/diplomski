import org.apache.sling.api.servlets.SlingAllMethodsServlet;
...
@Override
protected void doGet(SlingHttpServletRequest slingRequest, 
    SlingHttpServletResponse slingResponse) throws ServletException, IOException {

    ResourceResolver resourceResolver = slingRequest.getResourceResolver();
    PageManager pageManager = resourceResolver.adaptTo(PageManager.class);

    Page resourcePage = pageManager.getContainingPage(slingRequest.getResource());

    Designer designer = resourceResolver.adaptTo(Designer.class);
    Design resourceDesign = designer.getDesign(resourcePage);
}