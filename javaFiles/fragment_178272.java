private final Collection<GrantedAuthority> authorities;
    ...
    ArrayList<GrantedAuthority> temp = new ArrayList<GrantedAuthority>(
            authorities.size());
    temp.addAll(authorities);
    this.authorities = Collections.unmodifiableList(temp);