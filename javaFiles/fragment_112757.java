adapter.notifyDataSetInvalidated();
adapter.changeCursor(null);

// change to
adapter.changeCursor(null);
adapter.notifyDataSetChanged(); // maybe without this