String text = "मछली";
Locale hindi = new Locale("hi", "IN");
BreakIterator breaker = BreakIterator.getCharacterInstance(hindi);
breaker.setText(text);
int start = breaker.first();
for (int end = breaker.next();
  end != BreakIterator.DONE;
  start = end, end = breaker.next()) {
  System.out.println(text.substring(start,end));
}