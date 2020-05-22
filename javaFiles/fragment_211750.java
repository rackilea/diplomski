syncCategoryList = new SyncPreferenceItem[testChildData.size()];
for (int i=0;i <testChildData.size();i++ ) {
  switch (testChildData.get(i)) {
    case "VISIT":
      syncCategoryList[i] = new SyncPreferenceItem(R.drawable.sync_visit, R.string.PrefVisits,
          SynchronizationManager.SYNC_CATEGORY_TYPE.VISITS);
      break;
    case "CUSTOMERS":
      syncCategoryList[i] =  new SyncPreferenceItem(R.drawable.sync_customer, R.string.Customers,
          SynchronizationManager.SYNC_CATEGORY_TYPE.CUSTOMERS);
      break;
  }
}