v.findViewById(R.id.lastMonthButton).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.i("Testing","Button Clicked");
            v.findViewById(R.id.scrollvisibility).setVisibility(View.VISIBLE);
        }
    });