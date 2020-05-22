private void saveToSharedPreference(ArrayList<Boolean> arrayList) {
    Gson gson = new Gson();
    SharedPreferences sharedPreferences = this.getSharedPreferences("Test", Context.MODE_PRIVATE);
    sharedPreferences.edit().putString("ArrayList", gson.toJson(arrayList)).commit();
}

private ArrayList<Boolean> getSharedPreference() {
    Gson gson = new Gson();
    SharedPreferences sharedPreferences = this.getSharedPreferences("Test", Context.MODE_PRIVATE);
    String booleanString = sharedPreferences.getString("ArrayList", null);
    TypeToken<ArrayList<Boolean>> typeToken = new TypeToken<ArrayList<Boolean>>() {
    };
    ArrayList<Boolean> booleen = gson.fromJson(booleanString, typeToken.getType());
    return booleen;
}