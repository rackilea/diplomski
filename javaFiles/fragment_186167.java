@Override
public void onPageSelected(int position) {
            //This makes sure we get the previous position in the view pager and also
            //makes sure we don't go to -1 when you swipe back to the 0th position.

            //The problem here is if you are using action bar tabs, the user can also select the third tab, from the first tab and the index will be pointing to the second tab. I did not go out of my way to handle this case. But with a few checks you can handle the cases.

            //Also without proper checks, swiping backwards will be an issue, so adding those cases may also be necessary.
    int index = position == 0 ? position : position - 1;


    View view = mViewPager.getChildAt(index);

            // View at this point is the previous view in your view pager
            // and you can access your textviews in the following way.

    TextView myTextView = (TextView) view.findViewById(R.id.section_label);


            // If using action bar tabs, set the selected tab.
    mActionBar.setSelectedNavigationItem(position);
}