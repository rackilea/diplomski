@Resource
private WebServiceContext context;

if (context.isUserInRole("webServiceUsers")) { 
   //do whatever that user should be able to do or block them.
}