Resources res = getResources();
TypedArray ta = res.obtainTypedArray(R.array.array0);
int n = ta.length();
String[][] array = new String[n][];
for (int i = 0; i < n; ++i) {
    int id = ta.getResourceId(i, 0);
    if (id > 0) {
        array[i] = res.getStringArray(id);
    } else {
        // something wrong with the XML
    }
}
ta.recycle(); // Important!