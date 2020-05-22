@Override
protected void onDestroy() {
    super.onDestroy();
    unbindDrawables(findViewById(R.id.yourcontainer));
}

private void unbindDrawables(View view) {
    if (view == null)
        return;
    if (view.getBackground() != null)
    view.getBackground().setCallback(null);
    if (view instanceof ViewGroup) {
    for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
            unbindDrawables(((ViewGroup) view).getChildAt(i));
    }
    try {
        ((ViewGroup) view).removeAllViews();
    } catch (UnsupportedOperationException mayHappen) {
        Log.e("Error:", mayHappen.getMessage());
        }
    }
}