@Override
public Fragment getItem(int position) {

    if (position == 0) {

        return WelcomeFragment.newInstance("testtitle#1",R.layout.fragment_welcome_one,R.id.welcome1);

    }else if (position == 1){

        return WelcomeFragment.newInstance("testtitle#2", R.layout.fragment_welcome_two, R.id.welcome2);

    }else if (position == 2){

        return WelcomeFragment.newInstance("testtitle#3", R.layout.fragment_welcome_three, R.id.welcome3);

    }else if (position == 3){

        return WelcomeFragment.newInstance("testtitle#4", R.layout.fragment_welcome_four, R.id.welcome4);

    }

    return null;
}