private static boolean wasPause;

  @Override
  public void onPause() {
      super.onPause();
      wasPause = true;
  }

   public boolean onQueryTextChange(String arg0) {      

      if (wasPause && TextUtils.isEmpty(arg0)) {
          wasPause = false;
          searchView.setQuery(ItemAdapter.FilterByOriginal, false);
          return false;
      }
    ...