holder.cardView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
        // <-- Here change getSupportFragmentManager() to fragmentManager
        bottomSheetFragment.show(fragmentManager, bottomSheetFragment.getTag());

    }
});