String[] words = str.split(" ");
for (int i = 0; i < words.length; i++) {
  if (words[i].length() > 0) {
    if (!(words[i].substring(0, 1).equals("|"))) {
      sb.append(words[i].replaceFirst(words[i].substring(0, 1), words[i].substring(0, 1).toUpperCase()) + " ");
    } else {
      sb.append(words[i] + " ");
    }
  }
}