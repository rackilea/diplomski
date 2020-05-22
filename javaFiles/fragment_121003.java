/**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
        int position;

        /**
         * @param position
         */
        MyMenuItemClickListener(int position) {

            this.position = position;
        }

        /**
         * Click listener for popup menu items
         */

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.view:
                   // ...
                    return true;
                case R.id.edit:
                    // ...
                    return true;
                case R.id.delete:
                    // ...
                    return true;
                case R.id.favourite:
                   // ...
                    return true;
                default:
            }
            return false;
        }
    }