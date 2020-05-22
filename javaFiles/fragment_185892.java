private View mLastClickView;
public void onButtonTabClick(View v)
{
    // add these code
    if (mLastClickView != null) {
        mLastClickView.setBackgroundColor(getResources().getColor(R.color.unselected));
    }
    v.setBackgroundColor(getResources().getColor(R.color.selected));
    mLastClickView = v;

    Fragment fragment = null;
    switch (v.getId())
    {
        case R.id.button_equipment:
            fragment = new EquipmentFragment();

            break;
        case R.id.button_tech:

            fragment = new TechnicianFragment();

            break;

        case R.id.button_timeline:
            fragment = new TimeLineFragment();

            break;
    }

    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.replace(R.id.show_fragment, fragment);
    transaction.commit();
}