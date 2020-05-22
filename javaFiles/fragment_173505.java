yourListView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // updating clicked position variable on list item click.
            clickedPosition = position; 
            Intent detailsIntent = new Intent(ShopingCart.this, DetailsActivity.class);
            detailsIntent.putExtra("name", currentProduct.getProduct_txt());
            detailsIntent.putExtra("quantity", currentProduct.getQuantity());
            detailsIntent.putExtra("total", total);
            startActivityForResult(detailsIntent);
        }
    });