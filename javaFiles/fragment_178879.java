public void removePortlets(ActionRequest request, ActionResponse response)
            throws PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) request
                .getAttribute(WebKeys.THEME_DISPLAY);
        long groupId = themeDisplay.getScopeGroupId();
        String friendlyURL = "/demochildpage";
        boolean privateLayout = false;
        long userId = themeDisplay.getUserId();
        try {
            Layout layout = LayoutLocalServiceUtil.getFriendlyURLLayout(
                    groupId, privateLayout, friendlyURL);
            LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout
                    .getLayoutType();
            layoutTypePortlet.removePortletId(userId, "28");
            LayoutLocalServiceUtil.updateLayout(layout.getGroupId(),
                    layout.getPrivateLayout(), layout.getLayoutId(),
                    layout.getTypeSettings());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }