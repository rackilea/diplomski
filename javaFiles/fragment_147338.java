public boolean isPermitted(SubjectPrincipals principal, Permission p){
    if( p instanceof CustomPermission){
        CustomPermission cp = (CustomPermission) p;
        Class<?> type = cp.getType(); //AccountDetails
        Integer id = cp.getId(); //accountId
        Integer userId = principal.getPrimaryPrincipal(); //or username
        customPermissionCheckingLogic(userId, type, id);
    }
}