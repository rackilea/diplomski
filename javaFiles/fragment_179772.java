@Override
        public boolean onOptionsItemSelected(MenuItem item) {
            if (item.getItemId() == android.R.id.search) // set your own id if you have different id from search. 
            {
                tabLayout.setVisibility(View.GONE);
                return true;
            }  

            return super.onOptionsItemSelected(item);            
    }