private boolean isAdmin() {
    Authentication currentAuthObj = SecurityContextHolder.getContext().getAuthentication();
    List<GrantedAuthority> authorities = Arrays.asList(currentAuthObj.getAuthorites());
    for (GrantedAuthority auth : authorities) {
        if ("ROLE_ADMIN".equals(auth.getAuthority())) {
            return true;
        }
    }
    return false;
}

boolean currentUserIsAuthor = ...;

modelAndView.addObject("canEditPost", 
    Boolean.valueOf(currentUserIsAuthor || isAdmin());