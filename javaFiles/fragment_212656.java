int length = textPane.getDocument().getLength();
String text = textPane.getDocument().getText(0, length);
String search = "abc...";
int offset = text.indexOf(search);

if (offset != -1)
{
    textPane.setSelectionStart(offset);
    textPane.setSelectionEnd(offset + search.length();
    textPane.replaceSelection("123...");
}