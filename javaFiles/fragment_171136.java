private void showPopUpWindow() {
    autoSuggestionPopUpWindow.getContentPane().add(suggestionsPanel);
    autoSuggestionPopUpWindow.setMinimumSize(new Dimension(textComp.getWidth(), 30));
    autoSuggestionPopUpWindow.setSize(tW, tH);
    autoSuggestionPopUpWindow.setVisible(true);

    int windowX = 0;
    int windowY = 0;

    if (textComp instanceof JTextField) {//calculate x and y for JWindow at bottom of JTextField
        windowX = container.getX() + textComp.getX() + 5;
        if (suggestionsPanel.getHeight() > autoSuggestionPopUpWindow.getMinimumSize().height) {
            windowY = container.getY() + textComp.getY() + textComp.getHeight() + autoSuggestionPopUpWindow.getMinimumSize().height;
        } else {
            windowY = container.getY() + textComp.getY() + textComp.getHeight() + autoSuggestionPopUpWindow.getHeight();
        }
    } else {//calculate x and y for JWindow on any JTextComponent using the carets position
        Rectangle rect = null;
        try {
            rect = textComp.getUI().modelToView(textComp, textComp.getCaret().getDot());//get carets position
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }

        windowX = (int) (rect.getX() + 15);
        windowY = (int) (rect.getY() + (rect.getHeight() * 3));
    }

    //show the pop up
    autoSuggestionPopUpWindow.setLocation(windowX, windowY);
    autoSuggestionPopUpWindow.setMinimumSize(new Dimension(textComp.getWidth(), 30));
    autoSuggestionPopUpWindow.revalidate();
    autoSuggestionPopUpWindow.repaint();

}