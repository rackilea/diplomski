@Override
public UserDetails loadUserByUsername(String arg0)
        throws UsernameNotFoundException {

    MyUser user=new MyUser();
    /*get details of user and authorities from database whose username is   
            arg0 and place them in user instance */
    return user;
}

}