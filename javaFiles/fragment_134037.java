@Controller 
public class ContactListResponseController extends BaseWebServiceController 
{ 

 public static final String PATH = "/v" + VERSION + "/contacts"; 

 @Autowired 
 private ContactService contactService; 

 @RequestMapping(value = PATH, method = RequestMethod.GET) 
 @ResponseBody 
 public ContactListResponseBean doGetMyAssignedAccounts (@RequestParam("account") String accountId, 
                                                       HttpServletRequest request, 
                                                       HttpSession session, 
                                                       HttpServletResponse response, 
                                                          @ModelAttribute(User.USER_REQUEST_VAR) User user) 
  throws Exception 
  { 

    List<ContactSummaryWebServiceBean> contactList = contactService.getContactsListForCallPointWebService(accountId); 
    ContactListResponseBean result = new  ContactListResponseBean(contactList); 
    return result; 
  } 

}