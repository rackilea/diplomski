list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String product_name = productList.get(position).get(KEY_NAME); 
                Intent intent = new Intent(YourCurrentActivity.this,YourNextActivity.class);
                intent.putExtra("product_name",product_name);
                startActivity(intent);
            }
        });