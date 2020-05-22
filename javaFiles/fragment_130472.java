static int getLineOfOffset(JTextComponent comp, int offset) throws BadLocationException {
    Document doc = comp.getDocument();
    if (offset < 0) {
        throw new BadLocationException("Can't translate offset to line", -1);
    } else if (offset > doc.getLength()) {
        throw new BadLocationException("Can't translate offset to line", doc.getLength() + 1);
    } else {
        Element map = doc.getDefaultRootElement();
        return map.getElementIndex(offset);
    }
}

static int getLineStartOffset(JTextComponent comp, int line) throws BadLocationException {
    Element map = comp.getDocument().getDefaultRootElement();
    if (line < 0) {
        throw new BadLocationException("Negative line", -1);
    } else if (line >= map.getElementCount()) {
        throw new BadLocationException("No such line", comp.getDocument().getLength() + 1);
    } else {
        Element lineElem = map.getElement(line);
        return lineElem.getStartOffset();
    }
}

...

public void caretUpdate(CaretEvent e) {
    int dot = e.getDot();
    int line = getLineOfOffset(textComponent, dot);
    int positionInLine = dot - getLineStartOffset(textComponent, line);
    ...
}