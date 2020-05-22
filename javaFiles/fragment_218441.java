switch (position) {
    case 0:
        fragment= new GenesisFragment();
        sendBundleData(fragment);
        break;
    default:
        fragment=new GenesisFragment();
        break;
}