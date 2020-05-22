Authentication auth = SecurityContextHolder.getContext().getAuthentication();
if (auth != null) {
    Object principal = auth.getPrincipal();  
    if (principal instanceof UserDetails) {
        UserDetails user = (UserDetails) principal;
        ... // User is logged in, now you can access its details
    }
}