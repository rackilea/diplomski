for(String user : publishGroupType.getUsername()){
    UserModel userModel = userManagementClient.getUserModel(user);
    if(userModel != null){
        users.add(user);
        user.setGroup(this);
    }else{
       //handle missing user appropriately
    }
}