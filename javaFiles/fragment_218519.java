Map<EditText, String> map = new HashMap<EditText, String>();
EditText editTxt1 = (EditText) findViewById(R.id.editText1);
map.put(editTxt1, "editTxt1");
EditText editTxt2 = (EditText) findViewById(R.id.editText2);
list.add(editTxt2, "editTxt2");

for (Entry<String, String> e : map.entrySet()) {
    if(e.getValue().equals("something")) {
        System.out.println(e.getKey() + " was equal to somethihng");
    }
}