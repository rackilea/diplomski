public void editUser(int row)
{
    UserInformation userInf = new UserInformation();
    userModel.getSelectedMember(row);
    NewUserFrame_Edit edit = new NewUserFrame_Edit(userInf);
}