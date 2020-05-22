//
    private void deleteAllPets() {
        // TODO: Implement this method
        //
        Log.v(this.LOG_TAG, "rows deleted from pet database count is: ");

        this.petViewModel.deleteAllPets().observe(this,new Observer<Integer>(){
            @Override
            public void onChanged(final Integer result) {
                // here you will get result
                if (result == 0) {
                    // If no rows were deleted, then there was an error with the delete.
                    Toast.makeText(this, super.getString(R.string.catalog_delete_all_pets_failed) +
                    " ", Toast.LENGTH_LONG).show();
                } else {
                    // Otherwise, the delete was successful and we can display a toast.
                    Toast.makeText(this, super.getString(R.string.catalog_delete_all_pets_successful) +
                    " ", Toast.LENGTH_LONG).show();
                }
               // Close the activity
               //super.finish();
            }
        });
        // Show a toast message depending on whether or not the delete was successful.
    }