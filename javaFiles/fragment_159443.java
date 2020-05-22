ImageButton ib = (ImageButton) findViewById(R.id.your_button);
    ib.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            your_hidden_item.setVisibility(View.Visible);
        }
    });