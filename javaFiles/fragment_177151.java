public Fragment getFragment(int pos){
    switch(pos) {
        case 1:
            return new FragmentOne();
        case 2:
            return new FragmentTwo();
        case 3:
            return new FragmentThree();
        default:
            return FragmentOne();


    }
}