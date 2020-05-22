public void onItemSelected(AdapterView<?> parent, View view, int pos,
        long id) {
    String lang_Name = parent.getItemAtPosition(pos).toString();
    List<String> lang_Key = values.get(lang_Name);
    from_adapter2.clear():
    for(String s : lang_Key){
          from_adapter2.insert(s, from_adapter2.getCount());
    }
    from_adapter2.notifyDataSetChanged();
}