private View.OnClickListener ButtonClicked = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        ButtonExtended buttonView = (ButtonExtended) v;
        buttonView.getThumb(); //This is not allowed

    }
};