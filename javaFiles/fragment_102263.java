public Fragment getItem(int position) {

    Fragment fragment = null;
    switch(position){
        case product_result:
            fragment = FragmentProduct.newInstance("","");
            break;
    }
    return fragment;
}