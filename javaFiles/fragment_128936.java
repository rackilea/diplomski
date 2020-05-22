final PackageManager pm = getActivity().getPackageManager();

final IntentFilter filter = new IntentFilter(Intent.ACTION_MAIN);
filter.addCategory(Intent.CATEGORY_LAUNCHER);

List<IntentFilter> outFilters = new ArrayList<IntentFilter>();
outFilters.add(filter);

List<ComponentName> outActivities = new ArrayList<ComponentName>();
pm.getPreferredActivities(outFilters, outActivities, null);