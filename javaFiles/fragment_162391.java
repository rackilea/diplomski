@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        //Inflate the menu for this fragment
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

        //This is the important part here you can switch the visibility of your menu item
        MenuItem loading = menu.findItem(R.id.progress_bar);
        //Here I use a boolean that is global to my class to set the visibility of the item.
        loading.setVisible(toggle);
    }