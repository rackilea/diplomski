JTextArea txt = ...;
int caretOffset = txt.getCaretPosition();
int lineNumber = txt.getLineOfOffset(caretOffset);
int startOffset = txt.getLineStartOffset(lineNumber);
int endOffset = txt.getLineEndOffset(lineNumber);

txt.replaceRange("Replaced Text", startOffset, endOffset);