@Override
public void onResume() {
    if (detailViews >= 3) {
        // show ad
        detailViews = 0;
    }
}