User user = PortalUtil.getUser(request);
List<Organization> orgList = OrganizationLocalServiceUtil.getUserOrganizations(user.getUserId());
for (Organization org : orgList) { 
 String orgFriendlyURL = org.getGroup().getFriendlyURL();
.
.//some custom code
.
String myPath = "/" + language + "/group" + orgFriendlyURL + "/home";
LastPath lastPath = new LastPath(StringPool.BLANK, myPath);
HttpSession session = request.getSession();
session.setAttribute(WebKeys.LAST_PATH, lastPath);
_log.debug("Last Path  for current User[" + user.getScreenName() + "] is : " + lastPath);
break;
}