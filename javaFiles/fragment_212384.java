@Component
public class SecurityContextConfiguration {

    @EventListener
    public void setupSecurityContext(ContextRefreshedEvent event) {
    SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    SecurityContextHolder.getContext().setAuthentication(new SystemAuthentication());
    }
}