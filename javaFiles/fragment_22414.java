public void onItemSelected(AdapterView<?> parant, View v, int pos, long id) {
    StringWithTag s = (StringWithTag) parant.getItemAtPosition(pos);
    Object tag = s.tag;
    if (null != tag && tag instanceof String) {
        // Show toast
        // Toast.makeText(your context, (String) tag, Toast.LENGTH_SHORT).show();
    }
}