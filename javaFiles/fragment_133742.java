public void setUser(User user) throws SQLException, IOException{

    this.user = user;
    this.cart = this.user.getCartList();
    productTable.setItems(cart);
}