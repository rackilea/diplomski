casedanger1.setOnTouchListener(new View.OnTouchListener(){
    // track if the image is selected or not
    boolean isSelected = false;

    public boolean onTouch(View v, MotionEvent event) {
        if(isSelected) {
                casedanger1.setImageResource(R.drawable.casedanger1slct);
        } else {
                casedanger1.setImageResource(R.drawable.casedanger1);
        }
        // toggle the boolean
        isSelected = !isSelected;
        return false;
    }
});