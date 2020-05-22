ResourcePermissionLocalServiceUtil.removeResourcePermissions(
    _companyId,
    layout.getModelClassName(),
    ResourceConstants.SCOPE_INDIVIDUAL,
    String.valueOf(layout.getPrimaryKey()),
    userRoleId,
    new String[]{ActionKeys.VIEW}
);