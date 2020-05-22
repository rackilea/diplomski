// get our folding cell
    final FoldingCell fc = (FoldingCell) findViewById(R.id.folding_cell);

    // attach click listener to folding cell
    fc.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            fc.toggle(false);
        }
    });