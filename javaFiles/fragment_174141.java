btnTest.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        public void changePassVisibility (View view)
btnTest.setSelected(!btnTest.isPressed());

if (btnTest.isPressed()) {
    btnTest.setImageResource(R.drawable.PassVisible);
} else {
    btnTest.setImageResource(R.drawable.PassInvisible);
}
    }
});