BTNrandom.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Random r = new Random(); //Khai báo biến random
            n = r.nextInt(14) + 0 ; //hàm tạo biến random
            TVhienthi.setText(mangtrochoi[n]);
        }
    });