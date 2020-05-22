@Override
public void onResume() {
    super.onResume();
    stringArray = populateArray();
    wordListAdapter.setList(stringArray);
}