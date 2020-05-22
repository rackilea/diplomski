private OnClickListener closeListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent jumpage = new Intent(Rent.this, MainActivity.class);
            startActivity(jumpage);
            Rent.this.finish();
        }
    };