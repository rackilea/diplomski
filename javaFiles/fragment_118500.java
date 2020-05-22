@Override
public void onClick(View view) {
switch (view.getId()){
    case R.id.button1:
        bundle = new Bundle();
        bundle.putString(MainActivityFragment.DATA_TYPE, DATA_TYPE1);
        bundle.putStringArrayList(LISTVIEW_DATA, items1);
        break;
    case R.id.button2:
        bundle = new Bundle();
        bundle.putString(MainActivityFragment.DATA_TYPE, DATA_TYPE2);
        bundle.putStringArrayList(LISTVIEW_DATA, items2);
        break;
    case R.id.button3:
        bundle = new Bundle();
        bundle.putString(MainActivityFragment.DATA_TYPE, DATA_TYPE3);
        bundle.putStringArrayList(LISTVIEW_DATA, items3);
        break;
    default:
        break;
}

setListFragment(bundle);
}