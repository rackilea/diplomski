public boolean onOptionsItemSelected(final MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                //use onBackPressed() OR finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }