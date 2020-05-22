private String fileName = "deutsch.txt";
  File file = new File(getClass().getClassLoader().getResource(fileName).getFile());

  private RemoteAdapter() {
   this.spellchecker = SpellcheckerFactory.createSpellchecker(file);
  }