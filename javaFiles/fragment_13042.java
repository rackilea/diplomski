public String[] getUserAttributes(String name, String role){
    for(User user : this.getUserList()){
        if(user.getName().equals(name) && user.getRole().equals(role)){
            return new String[]{user.getID(), 
                                user.getRole(),
                                user.getEmail()}
        }
    }
    return null;
}