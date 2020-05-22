BreakIterator bi = BreakIterator.getSentenceInstance();
bi.setText(text);
int end, start = bi.first();
while ((end = bi.next()) != BreakIterator.DONE) {
    String sentence = text.substring(start, end);
    start = end;
}