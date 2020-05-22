@Override
public void checkPermission(Permission permission) {
   if (permission instanceof AWTPermission) {
       if (permission.getName().equals("showWindowWithoutWarningBanner")) {
           return;
       }
   }

   if (permission instanceof FilePermission) {
       if (permission.getActions().equalsIgnoreCase("execute")) {
          return;
       }
   }

   java.security.AccessController.checkPermission(permission);
}