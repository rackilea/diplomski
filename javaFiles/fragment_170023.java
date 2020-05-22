public void onClick(View v)
{
    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    YourFragment yourFragment= new YourFragment();
    fragmentTransaction.add(R.id.your_activity_id, yourFragment, "FRAGMENT");
    fragmentTransaction.commit();
}