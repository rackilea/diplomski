textPane.getHighlighter().removeAllHighlights();
textPane.getHighlighter().addHighlight(pos, pos + searchWordLength, red);
for int i = 0; i < matchList.size(); i++){
    int position = matchList.get(i);
    textPane.getHighlighter().addHighlight(position, possition + searchWordLength, grey);
}