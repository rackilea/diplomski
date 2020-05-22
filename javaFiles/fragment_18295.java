Authentication auth = SecurityContextHolder.getContext().getAuthentication();

Object principal = auth.getPrincipal();

MyCustomUser user = (MyCustomUser)principal;

user.myCustomMethod();