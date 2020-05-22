final List<ResolveInfo> activities = getPackageManager().queryIntentActivities(intent, 0);

List<DialogItem> appNames = new ArrayList<DialogItem>();

    for (ResolveInfo info : activities) {
            appNames.add(new DialogItem(info.loadLabel(getPackageManager()).toString(),
                    info.loadIcon(getPackageManager())));
    }
final List<DialogItem> newItem = appNames;
ListAdapter adapter = new ArrayAdapter<DialogItem>(activity,
                android.R.layout.select_dialog_item, android.R.id.text1, newItem) {
            public View getView(int position, View convertView, ViewGroup parent) {
                //Use super class to create the View
                View v = super.getView(position, convertView, parent);
                TextView tv = v.findViewById(android.R.id.text1);
                tv.setText(newItem.get(position).app);
                tv.setTextSize(15.0f);
                //Put the image on the TextView
                tv.setCompoundDrawablesWithIntrinsicBounds(newItem.get(position).icon, null, null, null);

                //Add margin between image and text (support various screen densities)
                int dp5 = (int) (5 * getResources().getDisplayMetrics().density + 0.5f);
                tv.setCompoundDrawablePadding(dp5);

                return v;
            }
};