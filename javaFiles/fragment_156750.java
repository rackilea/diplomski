if(Common.currentUser!=null) {
    Common.setSpanString("Hey, ", Common.currentUser.getName(), txt_user);
}
else{
    Commom.currentUser = new UserModel(uid,name,address,phone,email,password);
    Commom.currentUser.setName("Anonym");
    Common.setSpanString("Hey, ", Commom.currentUser.getName(), txt_user);
}