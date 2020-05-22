@RequestMapping( value = "/admin/module", method = RequestMethod.GET )
public String student( @RequestParam( defaultValue = "" )
String message, @RequestParam( defaultValue = "" )
String messageType, HttpServletRequest request, ModelMap model )
{
    model.addAttribute( "message", message );
    model.addAttribute( "messageType", messageType );
    model.addAttribute( new UploadItemBean() );
    HttpSession session = request.getSession();
    String returnVal = Credentials.checkSession( session );

    if( returnVal != null )
    {
        return returnVal;
    }

    return "als-student/module";
}