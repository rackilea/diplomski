public void addButtonClicked(View view){
        Memos lyrics = new Memos(LInput.getText().toString());
        dbHandler.addLyric(lyrics);
        printDatabase();
}

public void deleteButtonClicked(View view){
    String inputText = LInput.getText().toString();
    dbHandler.deleteLyrics(inputText);
    printDatabase();
}