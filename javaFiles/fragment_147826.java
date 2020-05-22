public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
    Intent intent = new Intent(MainActivityParent.this, MainActivity.class);
    intent.putExtra("product", adobe_products[position]);
    startActivity(intent);
}