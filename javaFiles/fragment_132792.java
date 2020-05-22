btnNext.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            position = (position + 1) % array.length;
            txtWord.setText(array[position][0]);
        }
    });

    btnBack.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            position = (position - 1) % array.length;
            txtWord.setText(array[position][0]);
        }
    });