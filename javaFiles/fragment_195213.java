@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            .accessDecisionManager(accessDecisionManager())
            .anyRequest()
            .permitAll()
        [...other configs...]
 }

@Bean(name = "accessDecisionManager")
public AccessDecisionManager accessDecisionManager() {
    List<AccessDecisionVoter> voters = new ArrayList<>();
    voters.add(new AdminPermitVoter());
    voters.add(new WebExpressionVoter());
    voters.add(new RoleVoter());
    voters.add(new AuthenticatedVoter());
    return new AffirmativeBased(voters);
}