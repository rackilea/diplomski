public class TheMan {
  private Set<String> uglyWords;

  public TheMan() {
    getBlacklist();
  }

  private void getBlacklist() {
    Scanner scanner = new Scanner(new File("wordsidontlike.txt"));
    while (scanner.hasNext()) {
      String word = scanner.nextLine();
      uglyWords.add(word);
    }
  }

  public String censorMessage(String message) {
    String censoredMsg = message;
    for (String word : uglyWords) {
      String replacement = word.charAt(0);
      StringUtils.rightPad(replacement, word.length(), '*');
      censoredMsg = censoredMsg.replaceAll(word, replacement);
    }
    return censoredMsg;
  }
}