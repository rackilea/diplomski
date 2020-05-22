private void updateInvites(){
    invitationArrayList.clear();
    for(Contacts contacts : contactsArrayList){
        if(contacts.isSelected()){
             invite(contact);
        }
    }
}