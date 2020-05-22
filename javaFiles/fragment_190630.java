protected Map<String, Object> executeImpl(WebScriptRequest req,
      Status status, Cache cache) 
{
   Map<String, String> templateVars = req.getServiceMatch().getTemplateVars();
   WebScript webscript = req.getServiceMatch().getWebScript();
   ResourceBundle webscriptRB = webscript.getResources();

   ....
}