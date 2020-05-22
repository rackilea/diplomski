for(UserModel user : userManagementClient.getAllUsers()){
    if(publishGroupType.getUsername().contains(user.getUsername())){
        users.add(user);
        user.setGroup(this);
    }
}