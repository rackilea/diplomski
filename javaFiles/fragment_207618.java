...
switch (position) {
    case 0:
        newFragment = new Fragment0();
        break;
    case 1:
        newFragment = new Fragment1();
        break;
    // etc..
    default:
        newFragment = new Fragment0();
}