public Fragment getItem(int num) {
        Fragment fragment = null;
        switch (num) {
            case TAB_PRODUCT_RESULT:
                fragment = FragmentProduct.newInstance("", "");
                break;
            case TAB_SECOND:
                fragment = MyFragment.getInstance(num);
                break;
            case TAB_THIRD:
                fragment = MyFragment.getInstance(num);
                break;
        }
        return fragment;
    }