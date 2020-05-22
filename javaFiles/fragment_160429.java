@Override
protected void updateItem(Client c, boolean empty) {
    super.updateItem(c, empty);
    if(!empty){
        cc.setClient(c);
    } else {
        cc.setClient(null);
    }
}