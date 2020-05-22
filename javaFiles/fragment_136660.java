private void removeBottomNavigationLabels(BottomNavigationView bottomNavigationView) {
    for (int i = 0; i < bottomNavigationView.getChildCount(); i++) {
        View item = bottomNavigationView.getChildAt(i);

        if (item instanceof BottomNavigationMenuView) {
            BottomNavigationMenuView menu = (BottomNavigationMenuView) item;

            for (int j = 0; j < menu.getChildCount(); j++) {
                View menuItem = menu.getChildAt(j);

                View small = menuItem.findViewById(android.support.design.R.id.smallLabel);
                if (small instanceof TextView) {
                    ((TextView) small).setVisibility(View.GONE);
                }
                View large = menuItem.findViewById(android.support.design.R.id.largeLabel);
                if (large instanceof TextView) {
                    ((TextView) large).setVisibility(View.GONE);
                }
            }
        }
    }

    BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
    for (int i = 0; i < menuView.getChildCount(); i++) {
        final View iconView = menuView.getChildAt(i).findViewById(android.support.design.R.id.icon);
        iconView.setPadding(0, 40, 0, 0);
        ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, displayMetrics);
        layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, displayMetrics);
        iconView.setLayoutParams(layoutParams);
    }
}