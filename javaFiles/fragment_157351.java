watchListBtn.setOnClickListener(new OnClickListener() {

        public void onClick(View v) {
            Intent intent = new Intent(DetailProductDescription.this, LoginForm.class);
intent.putExtra("from","watch");
            startActivity(intent);
        }
    });

wishListBtn.setOnClickListener(new OnClickListener() {

        public void onClick(View v) {
            Intent intent = new Intent(DetailProductDescription.this, LoginForm.class);
intent.putExtra("from","wish");
            startActivity(intent);
        }
    });