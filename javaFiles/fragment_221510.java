class User { 
    String firstName, lastName; 
    User(...){...} // Constructor
}

sequence(new User("Chris", "Nash")).unique(user -> user.firstName)