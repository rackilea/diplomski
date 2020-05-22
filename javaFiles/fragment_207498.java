@Override
protected void onDestroy() {
super.onDestroy();

unbindDrawables(findViewById(R.id.RootView));
System.gc();
}

private void unbindDrawables(View view) {
    if (view.getBackground() != null) {
    view.getBackground().setCallback(null);
    }
    if (view instanceof ViewGroup) {
        for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
        unbindDrawables(((ViewGroup) view).getChildAt(i));
        }
    ((ViewGroup) view).removeAllViews();
    }
}