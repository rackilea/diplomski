ThemeDisplay themeDisplay= (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

long groupId = themeDisplay.getScopeGroupId();
String name = (String)request.getAttribute(WebKeys.PORTLET_ID);
String primKey = portletDisplay.getResourcePK();
boolean view = permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.VIEW);
boolean congiguration = permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.CONFIGURATION);
boolean update = permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.UPDATE);