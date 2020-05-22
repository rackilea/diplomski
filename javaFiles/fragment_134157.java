public void createHashMap(String name, int mPosition) {
// init it only one time.
if(mHashMap  == null){
    mHashMap = new HashMap<String, Integer>();
}
mHashMap.put(name, mPosition);
Toast.makeText(context, name+": "+mPosition, Toast.LENGTH_LONG).show();