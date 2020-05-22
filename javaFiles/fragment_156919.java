public void switch_fragment(View view) {
        Fragment newFragment = null;
        switch (view.getID()) {
            case R.id.btn_2:
                newFragment = new Fragment1();
                break;
            case R.id.btn_1:
                newFragment = new Fragment2();
                break;
        }
        setFragment(this, newFragment);
    }