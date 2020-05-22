ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
imageView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent act2 = new Intent(view.getContext(), Activity2.class);
            startActivity(act2);
        }
    });