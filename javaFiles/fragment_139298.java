icons = new int[titles.length];
TypedArray iconsArray = getResources().obtainTypedArray(R.array.nav_drawer_icon);
for (int i = 0; i < icons.length; i++)
    icons[i] = iconsArray.getResourceId(i, -1);

iconsArray.recycle();