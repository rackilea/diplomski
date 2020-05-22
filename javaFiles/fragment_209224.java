public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    switch (parent.getId()) {
        case R.id.listView1:       // this is ID in XML layout
            // do action for ListView 1;
            break;
        case R.id.listView2:       // this is ID in XML layout
            // do action for ListView 2;
            break;
        default:
            break;
    }

}