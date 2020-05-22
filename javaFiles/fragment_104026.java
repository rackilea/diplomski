public void decadeDotsFragment(){

    DecadeDotsFragment fragment = new DecadeDotsFragment();
    fragment.selectDot(0);//here should pass required position
    FragmentManager manager = getSupportFragmentManager();
    manager.beginTransaction()
            .replace(R.id.dots_fragment, fragment)
            .addToBackStack(null)
            .commit();
}