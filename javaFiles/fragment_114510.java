public class BranchLocator extends MVCPortlet {
    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)throws IOException, PortletException 
    {
        if ("CityCall".equalsIgnoreCase(resourceRequest.getResourceID())) 
        {
             String state_id = resourceRequest.getParameter("state_id");
                //logic to retrieve data
        }
    }
}