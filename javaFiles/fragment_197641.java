protected int getLineNumber(int modelPos) throws BadLocationException {

    return textArea.getLineOfOffset(modelPos) + 1;

}

Rectangle viewRect = scrollPane.getViewport().getViewRect();

Point startPoint = viewRect.getLocation();
int pos = textArea.viewToModel(startPoint);

try {

    int startLine = getLineNumber(pos);

    Point endPoint = startPoint;
    endPoint.y += viewRect.height;

    pos = textArea.viewToModel(endPoint);
    int endLine = getLineNumber(pos);

    System.out.println(startLine + " - " + endLine);

} catch (BadLocationException exp) {
}