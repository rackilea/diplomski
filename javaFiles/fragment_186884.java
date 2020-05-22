public void onListItemClick(ListView parent, View view, int position, long id) {
                        Model clickedRowData = parent.getItemAtPosition(position);
                        clickedRowData.counter++;
                        // notify the adapter that something was updated
                        mAdapter.notifyDataSetChanged();
                    }