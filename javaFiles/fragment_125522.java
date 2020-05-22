private void saveContent() {
    String content = uinput.getText().toString();
    String name = "Note 1"; // You can create a new EditText for getting name
    // Using SharedPreferences (the simple way)
    SharedPreferences sp = this.getApplicationContext().getSharedPreferences("notes", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sp.edit();
    editor.putString(name, content);
    editor.apply();
}

private Map<String, ?> getAllNotes() {
    SharedPreferences sp = this.getApplicationContext().getSharedPreferences("notes", Context.MODE_PRIVATE);
    return sp.getAll();
}

private String getNoteContent(String noteName) {
    SharedPreferences sp = this.getApplicationContext().getSharedPreferences("notes", Context.MODE_PRIVATE);
    return sp.getString(noteName, "Default Value (If not exists)");
}