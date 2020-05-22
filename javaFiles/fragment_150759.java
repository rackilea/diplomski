public class CustomizedTileProcessor extends TilesRequestProcessor
    {
     @Override
 protected void processForwardConfig(HttpServletRequest pRequest, 
       HttpServletResponse pResponse, ForwardConfig pForward) 
       throws IOException, ServletException
   {
      if(isChromeBrowser(pRequest))
      {
         ForwardConfig newForward = new ForwardConfig(pForward.getName(),
         pForward.getPath()+"_chrome", pForward.getRedirect(),
         pForward.getContextRelative());

         super.processForwardConfig(pRequest, pResponse, newForward);
      }
      else
      {
         super.processForwardConfig(pRequest, pResponse, pForward);
      }
   }
}