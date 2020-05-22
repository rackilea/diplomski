imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                showPopupMenu(imageView, position);
            }
        });


    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view, int position) {
        PopupMenu popup = new PopupMenu(context, view, Gravity.END);
        MenuInflater inflater = popup.getMenuInflater();

        inflater.inflate(R.menu.favourite_menu, popup.getMenu());

        //set menu item click listener here
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener(position));
        popup.show();
    }