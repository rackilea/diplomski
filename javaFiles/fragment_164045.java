findViewById(R.id.txt).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        TextView textView = (TextView) v;
        if (textView.isSelected()) {
            textView.setTextColor(Color.RED);
            v.setSelected(false);
        } else {
            textView.setTextColor(Color.BLUE);
            v.setSelected(true);
        }

    }
});