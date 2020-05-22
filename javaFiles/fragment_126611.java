Method method = action.getClass().getDeclaredMethod(actionmethod);
RequiredPermission permission = method.getAnnotation(RequiredPermission.class);
if (sessionUser.inRoles(permission.getRoles()) {
    return invocation.invoke();
}

return Constants.LOGIN_REQUIRED_RESULT;