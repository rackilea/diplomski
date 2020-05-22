public void setShoppingListProducts(List<ShoppingListProduct> shoppingListProducts) {

    for (ShoppingListProduct sp : shoppingListProducts) {
            sp.setShoppingList(this);   
    }

        this.shoppingListProducts = shoppingListProducts;
}