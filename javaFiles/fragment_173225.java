cref.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        if (task.isSuccessful()) {
            for (DocumentSnapshot document : task.getResult()) {
                String pdesc = document.getString("pdesc");
                productdescription.add(pdesc);
                String pname = document.getString("pname");
                productname.add()pname;
                String pprice = document.getString("pprice");
                productprice.add(pprice);
                String pstock = document.getString("pstock");
                productquantity.add(pstock);
                Log.d("TAG", pdesc + " / " + pname + " / " + pprice + " / " + pstock); 
            }
            MyProductAdapter ma = new MyProductAdapter(
                productimage,
                ProductsAll.this,
                productname,
                productdescription,
                productquantity,
                productprice
            );
            prdctlist.setAdapter(ma);
        }
    }
});