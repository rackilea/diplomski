public static void changeToolbarFont(Toolbar toolbar, Activity context) {
    for (int i = 0; i < toolbar.getChildCount(); i++) {
        View view = toolbar.getChildAt(i);
        if (view instanceof TextView) {
            TextView tv = (TextView) view;
            if (tv.getText().equals(toolbar.getTitle())) {
                applyFont(tv, context);
                break;
            }
        }
    }
}

public static void applyFont(TextView tv, Activity context) {
    tv.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/customFont"));
}