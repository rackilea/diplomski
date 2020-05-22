for (String word : words) {
     Pattern rx = Pattern.compile("\\b" + word + "\\b", Pattern.CASE_INSENSITIVE);
     s = rx.matcher(s).replaceAll(new String(new char[word.length()]).replace('\0', '*'));
}

// s: i will hit your **** right ***