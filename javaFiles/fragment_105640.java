String s = ...;
int number_chars = ...;
BreakIterator bi = BreakIterator.getWordInstance();
bi.setText(s);
int first_after = bi.following(number_chars);
// to truncate:
s = s.substring(0, first_after);