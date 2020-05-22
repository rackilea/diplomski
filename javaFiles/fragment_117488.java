SecurityContext securityContext = SecurityContextHolder.getContext();
CustomUser user;
if(null != securityContext.getAuthentication()){
   user = (CustomUser) securityContext.getAuthentication().getPrincipal();
}
int id = user.getId();