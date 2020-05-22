public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
    Intent intent = new Intent(MainActivity.this, Ekantipur.class);
    intent.putExtra("url", adobe_products[position]);
    startActivity(intent);
}