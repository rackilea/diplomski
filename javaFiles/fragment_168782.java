SharedPreferences pref = getSharedPreferences("lado", MODE_PRIVATE);

 List<String> list = new ArrayList<>();
Gson gson = new Gson();
Dictionary dictionary = gson.fromJson(pref.getString("word", ""), Dictionary.class);
if (dictionary != null)
    for (Words words : dictionary.getWordsList()) {
        list.add(words.getName());
    }
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, android.R.id.text1, list);

// Assign adapter to ListView
textList.setAdapter(adapter);

//**Remove when click on item**
textList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Gson gson = new Gson();
        Dictionary dictionary = gson.fromJson(pref.getString("word", ""), Dictionary.class);
        for (Words words :
                dictionary.getWordsList()) {
            if (words.getName().equalsIgnoreCase(list.get(i))) {
                dictionary.getWordsList().remove(words);
                list.remove(i);
                break;
            }
        }
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("word", new Gson().toJson(dictionary));
        editor.commit();

        adapter.notifyDataSetChanged();
    }
});