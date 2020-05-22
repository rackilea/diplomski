List<String>getWordsOnPage(String url) {
  // read words within <ul class="result-list"> element.
}

void getAllWords() {
  List<String> all = new ArrayList<String>();
  for (char letter = 'A'; letter <= 'Z'; ++letter) {
    for (int start = 0; true; start += 25) {
      List<String> page = getWordsOnPage("http://www.whonamedit.com/eponyms/" + letter + "/?start=" + start + "&maxrows=25");
      if (page.isEmpty()) {
        break;
      }
      all.addAll(page);
    }
  }
}