protected boolean hasAdminRole() {
    ClientInfo clientInfo = getClientInfo();
    List<Role> roles = clientInfo.getRoles();
    boolean isAdmin = false;
    for (Role role : roles) {
        if (role.getName().equals("admin")) {
            isAdmin = true;
            break;
        }
    }
    return isAdmin;
}

@Post
public XX handlePost(YY content) {
    if (!hasAdminRole()) {
        throw new ResourceException(Status.CLIENT_ERROR_FORBIDDEN);
    }

    (...)
}