plus.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        addtocart.setVisibility(View.VISIBLE);
        count++;
        textcount.setText(String.valueOf(count));
        checkBounds();
    }
});

minus.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        count--;
        textcount.setText(String.valueOf(count));
        checkBounds();
    }
});