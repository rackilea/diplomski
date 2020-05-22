public class RetinaAuthenticationServiceImpl implements RetinaAuthenticationService {

    private Map<String, List<String>> apiKeyRoleMappings;

    @Override
    public User loadUserByApiKey(String token) {
        User user = null;
        if(this.apiKeyRoleMappings.containsKey(token)){
            user = new User();
            user.setApiKey(token);
            List<Role> authorities = new ArrayList<Role>();
            for(String roleStr : this.apiKeyRoleMappings.get(token)){
                Role role = new Role();
                role.setName(roleStr);
                authorities.add(role);
            }
            user.setAuthorities(authorities );
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.setEnabled(true);
        }else{
            throw new BadCredentialsException("ApiKey " + token + " not found");
        }
        return user;
    }

    public Map<String, List<String>> getApiKeyRoleMappings() {
        return apiKeyRoleMappings;
    }

    public void setApiKeyRoleMappings(Map<String, List<String>> apiKeyRoleMappings) {
        this.apiKeyRoleMappings = apiKeyRoleMappings;
    }


}