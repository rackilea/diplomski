if (password.equals(provider.getPassword()))
{
    Collection<? extends GrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(providerName, password, authorities);
    return authenticationToken;
}