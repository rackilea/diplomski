//The onClick on xml requires a function of signature void(View) which is the clicked view (in this case the ImageView)
public void clickedOverlay(View view)
{
    //ImageView is clicked
    RelativeLayout rlLayout = (RelativeLayout) findViewById(R.id.over_lay_page);
    rlLayout.setVisibility(View.GONE);
}