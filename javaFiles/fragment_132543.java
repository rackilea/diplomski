public class SpringActiveProfileResolver implements ActiveProfilesResolver {

    @Override
    public String[] resolve(final Class<?> aClass) {
        final String activeProfile = System.getProperty("spring.profiles.active");
        return new String[] { activeProfile == null ? "integration" : activeProfile };
    }
}