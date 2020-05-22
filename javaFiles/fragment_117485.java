SecurityContext securityContext = SecurityContextHolder.getContext();
Object principal;
String username;
if(null != securityContext.getAuthentication()){
   principal = securityContext.getAuthentication().getPrincipal();
   username = securityContext.getAuthentication().getName();
}