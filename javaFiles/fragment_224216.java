@Override
public void onClick(View v) {
switch (v.getId()) {
    case R.id.btnNext:

        // Add this line to avoid crash
        timer.cancel();

        frag = new FragmentQuestion2();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.container,frag);

        fragmentTransaction.commit();

        break;
}