for (UserGroup userGroup : userGroups) {
    String userGroupName = userGroup.getName();
    // for locale specific title (optional, can be null)
    Map<Locale, String> titleMap = new HashMap<Locale, String>();
    titleMap.put(Locale.ENGLISH, userGroupName);

    // for locale specific description (optional, can be null)
    Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
    titleMap.put(Locale.ENGLISH, "Role created for UserGroup - " + userGroupName);

    int type = RoleConstants.TYPE_REGULAR;

    // adding the role
    Role role = RoleLocalServiceUtil.addRole(userId, Role.class.getName(), 0, userGroupName, titleMap, descriptionMap, type, null, null);

    // assigning the UserGroup to the role
    GroupLocalServiceUtil.addRoleGroups(role.getRoleId(), new long[]{userGroup.getGroupId()}); // need to pass groupId and not userGroupId
}