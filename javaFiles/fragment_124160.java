private void showData(DataSnapshot dataSnapshot) {

        //[...]

        if (mListView.getAdapter() instanceof CustomListAdapter) {
            ((CustomListAdapter)mListView.getAdapter()).updateList(array);
        }
    }