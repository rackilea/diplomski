public void addPermission(String permission, String resource){
  permissions.put(new Permission(permission, ()-> {
    if (permission.charAt(permissions.size() - 1) == '*') 
      return true;
    return false;
  }));
}