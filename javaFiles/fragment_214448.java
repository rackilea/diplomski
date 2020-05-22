ViewGroup root; // root is a reference of the root of your content view
// in the onCreate method

root = (ViewGroup) getLayoutInflater().inflate(R.layout.your_activity_layout_file, null);

// later use it:
changeViewsState(root, false);