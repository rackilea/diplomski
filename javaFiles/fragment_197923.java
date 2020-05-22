Button button = (Button) findViewById(R.id.AButton);
button.setOnClickListener(new View.OnClickListener() {
    public void onClick(View view) {
        TextView tv = AndroidAssignment2_1.this.findViewById(R.id.Answers);
        tv.setVisibility(View.VISIBLE);
    }
});