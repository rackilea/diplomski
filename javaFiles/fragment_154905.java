public void onShowPopup(View view) {
    View layout = getLayoutInflater().inflate(R.layout.popup_menu, null);

    int hMargin = 0;
    int vMargin = 0;

    // Pre-Lollipop the FAB shadow is factored into the button size, KitKat and on the
    //  shadow isn't part of the button size.  By comparing the actual width to the expected
    //  width we can compute an offset necessary to position the popup adjacent to the FAB
    if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
        hMargin += (int) (view.getWidth() - Util.dpToPixels(this, 56)) / 2;
        vMargin += (int) (view.getHeight() - Util.dpToPixels(this, 56)) / 2;
    }

    PositionedPopupWindow.withLayout(layout).showRelativeToView(
            view,
            PositionedPopupWindow.AnchorPoint.Automatic,
            hMargin,
            vMargin
    );
}