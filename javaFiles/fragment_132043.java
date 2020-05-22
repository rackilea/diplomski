FileHandle handle = Gdx.files.local("words.txt");
  String text = handle.readString();
  String wordsArray[] = text.split("\\r?\\n");
  for(String word : wordsArray) {
      words.add(word);
  }