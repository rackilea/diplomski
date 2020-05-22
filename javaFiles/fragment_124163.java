private void showData(DataSnapshot dataSnapshot) {

        //[...]

        if (mListView.getAdapter() instanceof CustomListAdapter) {
            ((CustomListAdapter)mListView.getAdapter()).updateList(array);
            listView.setBackgroundColor(ContextCompat.getColor(listView.getContext(), R.color.loaded_color));
        }
    }