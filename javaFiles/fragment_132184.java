// in the class scope
Button b4 = null;

// in the method scope
if (4val != null && 4val.length() > 0){
    b4 = new Button(this);
    b4.setText(answer4val);
    b4.setTextSize(18);
    layout.addView(b4, layoutParams);
    b4.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            reason(4);
        }
    });
}