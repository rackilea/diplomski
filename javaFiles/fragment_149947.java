public final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
boolean flag = false;

for (Authority authority: authentication.getAuthorities()) {
    if (authority.getAuthority().equals(role)) flag = true;
}