@Override
public Fragment getItem(int position) {
    switch (position) {
        case 0: // Fragment # 0 - This will show FirstFragment
            return FirstFragment.newInstance(0, "Page # 1");
        case 1: // Fragment # 0 - This will show FirstFragment different title
            return FirstFragment.newInstance(1, "Page # 2");
        case 2:
            return FirstFragment.newInstance(2, "Page # 3");
        default:
            return new Fragment();
    }
}