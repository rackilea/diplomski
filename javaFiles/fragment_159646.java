vHolder.imageView.setTag(pos);  // set current pos
vHolder.imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        showCarEditDialog(Integer.parseInt(v.getTag().toString()));
    }
});