RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);    

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        imageView.setImageResource(R.drawable.ring);                     
        imageView.setLayoutParams(params);

    }
});