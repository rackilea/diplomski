public void updateListItemFragment() {
      android.support.v4.app.Fragment inputData = mSectionsPagerAdapter.getRegisteredFragment(1);
      ListView lv = ((PlaceholderFragment)inputData).listViewItem;
      //for test purposes I refill listview with no items - here you need to hand filled BaseAdapter instance: CustomAdapter innerAdapter = new CustomAdapter(ArrayList<yourDataModel>, getContext());
      lv.setAdapter(null);
  }