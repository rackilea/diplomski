Button button = (Button) findViewById(R.id.your_button);
ImageView imageView = (ImageView) findViewById(R.id.imgTest);

button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            imageView.animate().alpha(0.2f).setDuration(1000);

    }
};