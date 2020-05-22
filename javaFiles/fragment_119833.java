populatePage(layout);

public void populatePage(View v){

    ...other code here...
    RelativeLayout relativeLayout = (RelativeLayout)v. findViewById(R.id.id_that_exists_in_your_xml);
    relativeLayout.addView(ll, 0, new ViewGroup.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT));
}