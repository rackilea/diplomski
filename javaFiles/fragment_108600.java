if (Arrays.asList(UsernameArray).contains(LoginPanel.Username) &&    
    Arrays.asList(PasswordArray).contains(LoginPanel.Password) && 
    //this way me make sure the username and password are at the same position. 
    Arrays.asList(UsernameArray).indexOf(LoginPanel.Username) == Arrays.asList(PasswordArray).indexOf(LoginPanel.Password) 
)
{
                   //Do something
}