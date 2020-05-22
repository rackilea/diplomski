List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    SimpleGrantedAuthority authority = new SimpleGrantedAuthority("VERIFIED");
    authorities.add(authority);
    UserDetails user = new User(mobile_Number, existing_Password, authorities);

        return user;

        .......