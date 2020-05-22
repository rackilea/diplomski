private ArrayList<HashMap<String, String>> reformedBundle;

...

lvResults.setOnItemClickListener(new OnItemClickListener() {
    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
        HashMap<String, String> map = reformedBundle.get(pos);
    }
});