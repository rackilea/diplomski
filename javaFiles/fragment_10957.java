@Override
public Fragment getItem(int arg0) {
    // TODO Auto-generated method stub
    Fragment frag=null;
    if (arg0 == 0) {
        frag = new TAB_1();
    } else if(arg0 == 1) {
        frag = new TAB_2();
    }
    return frag;
}