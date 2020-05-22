final MenuItem item = menu.findItem(R.id.nav_cart);
    MenuItemCompat.setActionView(item, R.id.custom_layout_cart);
    actionView = MenuItemCompat.getActionView(item);
    ImageView btn = (ImageView) actionView.findViewById(R.id.cart_bag);
    NotificationBadge count = (TextView) actionView.findViewById(R.id.badge);
    btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(HomeScreen.this, "hello", Toast.LENGTH_SHORT).show();
    }
});