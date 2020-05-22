String input = "Hello World. " 
    + "Today in the U.S.A., it is a nice day! "
    + "Hurrah!"
    + "The U.S. is a great country. "
    + "Here it comes... "
    + "Party time!";
BreakIterator iterator = BreakIterator.getSentenceInstance();
iterator.setText(input);
int start = iterator.first();
for (int end = iterator.next(); end != BreakIterator.DONE; start = end, end = iterator.next()) {
    System.out.println(input.substring(start, end));
}