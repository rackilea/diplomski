@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_progress_show) {
            progress_menu_item.setActionView(R.layout.menu_item_layout);

            if(viewPager.getCurrentItem()==1)
            {
                frag2.reloadWebView(); // Call method
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }