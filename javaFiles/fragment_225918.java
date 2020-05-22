public class SecurityHelper {
     public static boolean isAuthenticated(){
      Subject currentUser = SecurityUtils.getSubject();
      return currentUser.isAuthenticated();
     }
     public static void checkPermission(String permissionCode){
          Subject currentUser = SecurityUtils.getSubject();
          currentUser.checkPermission(permissionCode);
     }
     public static void checkPermission(String... permissionCodes){
          Subject currentUser = SecurityUtils.getSubject();
          currentUser.checkPermissions(permissionCodes);
     }
     ... and so on