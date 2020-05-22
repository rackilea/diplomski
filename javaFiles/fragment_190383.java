private void highlightFrame(JPanel frame){
    Rectangle rect = frame.getBounds();

    int c = rect.x + rect.width / 2; 
    int w = scrollPane.getViewport().getWidth();
    int x = c-w/2;
    rect.setBounds(x, rect.y, w, rect.height);

    innerPanel.scrollRectToVisible(rect);     
    frame.setBorder(BorderFactory.createLineBorder(Color.red,2));
}          

private void unhighlightFrame(JPanel frame){
    frame.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
}