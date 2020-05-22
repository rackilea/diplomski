view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent detailsIntent = new Intent(context, DetailsActivity.class);
            detailsIntent.putExtra("name", currentProduct.getProduct_txt());
            detailsIntent.putExtra("quantity", currentProduct.getQuantity());
            detailsIntent.putExtra("total", total);
            context.startActivity(detailsIntent);
        }
    });