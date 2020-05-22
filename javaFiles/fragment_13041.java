public User findUser(String name, String role){
    for(User user : this.getUserList()){
        if(user.getName().equals(name) && user.getRole().equals(role)){
            return user;
        }
    }
    return null;
}