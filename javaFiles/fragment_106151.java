protected void loadPreferences(){
    SharedPreferences data = getApplicationContext().getSharedPreferences("saveNumber", Context.MODE_PRIVATE);
    for (int i = 0;; ++i){
        final String str = data.getString(String.valueOf(i), "");
        if (!str.equals("")){
            adapter.add(str);
        } else {
            break; // Empty String means the default value was returned.
        }
    }
}