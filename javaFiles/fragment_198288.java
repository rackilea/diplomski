public interface ProfileProjection {
    @Value("#{target.primaryEmailAddress.emailAddress}")
    String getEmailAddress();
    String getPrimaryEmailAddress();
    String getUsername();
    String getDisplayName();
    @Value("#{target.getGravatarUrl()}")
    String getGravatarUrl();
}