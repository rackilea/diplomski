public class UserUtility {

    public static String getUsername(){
        if (SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null) {
            return SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        }
        return null;
    }
}