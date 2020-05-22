@Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
         getMenuInflater().inflate(R.menu.test_next, menu);
         return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.action_next:
            // .. do your thing
            return true;
        // ... other actions
        }
        return super.onOptionsItemSelected(item);
    }