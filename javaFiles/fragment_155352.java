mDrawerListView.setAdapter(new ArrayAdapter<String>(
    getActionBar().getThemedContext(),
    android.R.layout.simple_list_item_activated_1,
    android.R.id.text1,
    new String[]{
            getString(R.string.title_section1),
            getString(R.string.title_section2),
            getString(R.string.title_section3),
    }));