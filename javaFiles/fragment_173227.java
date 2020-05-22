cref.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            List<Product> productList = new ArrayList<>();
            for (DocumentSnapshot document : task.getResult()) {
                Product product = document.toObject(Product.class);
                productList.add(product);
                Log.d("TAG", product.getPdesc() + " / " + product.getPname() + " / " + product.getPprice() + " / " + product.getPstock()); 
            }
            MyProductAdapter ma = new MyProductAdapter(
                productimage,
                ProductsAll.this,
                productList
            );
            prdctlist.setAdapter(ma);
        }
    }
});