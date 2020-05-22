@Override
protected void onResume() {
    TextView cartQry = (TextView) view.findViewById(R.id.actionbar_cart_qty);
    int count = ShoppingCart.getInstance().getTotalItems();
    cartQry.setText(Integer.toString(count));

    super.onResume();
}