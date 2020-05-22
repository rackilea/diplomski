// change these two lines for the following examples
String text = "This is some text.";
BreakIterator boundary = BreakIterator.getCharacterInstance();

// boiler plate code
boundary.setText(text);
int start = boundary.first();
for (int end = boundary.next(); end != BreakIterator.DONE; end = boundary.next()) {
    System.out.println(start + " " + text.substring(start, end));
    start = end;
}