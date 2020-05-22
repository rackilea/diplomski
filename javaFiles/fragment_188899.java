EditText some = mView.findViewById(R.id.some);
    some.setFocusable(false);
    some.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            System.out.println("your View got clicked");
        }
    });