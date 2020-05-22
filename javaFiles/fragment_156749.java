if(Common.currentUser!=null) {
    Common.setSpanString("Hey, ", Common.currentUser.getName(), txt_user);
}
else{
    UserModel userModel= new UserModel(uid,name,address,phone,email,password);
    userModel.setName("Anonym");
    Common.setSpanString("Hey, ", name, txt_user);
}