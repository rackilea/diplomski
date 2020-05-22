BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
iterator.setText(content);
int start = iterator.first();

List<String> sentences = new ArrayList<String>();
for (int end = iterator.next(); end != BreakIterator.DONE; start = end, end = iterator.next()) {
    //System.out.println(content.substring(start,end));
    sentences.add(content.substring(start,end));
}