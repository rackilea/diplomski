@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @SuppressWarnings("rawtypes")
    @Override
    protected AccessDecisionManager accessDecisionManager() {
        List<AccessDecisionVoter> voters = new ArrayList<>();
        voters.add(new AdminPermitVoter());
        voters.add(new RoleVoter());
        voters.add(new AuthenticatedVoter());
        return new AffirmativeBased(voters);
    }

}