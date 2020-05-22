homeScreenPlus.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        dodajInterval();
        homeScreenMinus.setEnabled(counter > 0);
    }
});