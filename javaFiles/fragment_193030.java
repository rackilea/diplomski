TypedValue tv = new TypedValue();
    if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
    {
      googleMapPadding = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
    }

    gMap.setPadding(0, googleMapPadding, 0, 0);