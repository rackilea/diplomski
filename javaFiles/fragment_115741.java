public class CustomAuditorAware implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        String loggedName = SecurityContextHolder.getContext().getAuthentication().getName();
        return loggedName;
    }

}