popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

    @Override
    public void onDismiss() {
        mDrawerLayout2.setAlpha((float) 1);
        popup.dismiss();

    }
});