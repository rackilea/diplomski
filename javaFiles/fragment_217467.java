class AuditorAwareImpl implements AuditorAware<Person> {

    @Override
    public Optional<Person> getCurrentAuditor() {
        PersonRepository personRepo = ApplicationContextProvider.getApplicationContext().getBean(PersonRepository.class)
        return Optional.of(personRepo.findByUserPrincipalName(SecurityContextHolder.getContext().getAuthentication().getName() + "@email.com"));
    }
}


@Component(value = "applicationContextProvider")
public class ApplicationContextProvider implements ApplicationContextAware {

    private static class AplicationContextHolder {
        private static final InnerContextResource CONTEXT_PROV = new InnerContextResource();
    }

    private static final class InnerContextResource {

        private ApplicationContext context;

        private void setContext(ApplicationContext context) {
            this.context = context;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return AplicationContextHolder.CONTEXT_PROV.context;
    }

    @Override
    public void setApplicationContext(ApplicationContext ac) {
        AplicationContextHolder.CONTEXT_PROV.setContext(ac);
    }

}