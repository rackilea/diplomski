private void SwitchLayout2() 
{
    RelativeLayout Layout1 = (RelativeLayout)findViewById(R.id.layout1);
    RelativeLayout Layout2 = (RelativeLayout)findViewById(R.id.layout2);

    // Enable Layout 2 and Disable Layout 1
    Layout1 .setVisibility(View.GONE);
    Layout2.setVisibility(View.VISIBLE);
}

private void SwitchLayout1() 
{
    RelativeLayout Layout1 = (RelativeLayout)findViewById(R.id.layout1);
    RelativeLayout Layout2 = (RelativeLayout)findViewById(R.id.layout2);

    // Enable Layout 1 & Disable Layout2
    Layout1.setVisibility(View.VISIBLE);
    Layout2.setVisibility(View.GONE);
}