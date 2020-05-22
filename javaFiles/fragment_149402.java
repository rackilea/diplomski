class anycastModel extends javax.swing.AbstractListModel<String>{


    @Override
    public int getSize() {
        return anycast_users_num;
    }

    @Override
    public String getElementAt(int i) {
       return anycast_users_list[i];
    }

    public void updateList(){

        fireContentsChanged(this, 0, anycast_users_num);
    }
}
void set_usermodel(){
    anycast_model=new anycastModel();
    anycast_users.setModel(anycast_model);
}