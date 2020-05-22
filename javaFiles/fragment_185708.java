@Override
public void onInfoWindowClick(Marker marker) {
    LinearLayout secondLL = (LinearLayout) findViewById(R.id.bigpicture);
    int visibility = secondLL.getVisibility();
    if(visibility == View.GONE)
    {
         secondLL.setVisibility(View.VISIBLE);
    }

}