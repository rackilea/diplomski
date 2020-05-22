public  List<User> getUserList(String name, String role) {
    for(User user : this.getUserList()){
        if(user.getName().equals(name) && user.getRole().equals(role)){
            List<User> list = new ArrayList<>(1);
            list.add(user);
            return list;
        }
    }
    return Collections.emptyList();
}