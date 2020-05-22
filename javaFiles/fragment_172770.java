@Bean
AuditorAware auditor() {
    // return () -> "system";  // Fixed principal
    // and for spring-security
    return () -> {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        return authentication.getPrincipal().toString();
    }
}