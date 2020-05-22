private void paintText(Graphics2D g2, int row, String text){
    g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    for(int i = 0; i < text.length(); i++){
        g2.drawString(Character.toString(text.charAt(i)), i * gridSize, row * gridSize);   
    }  
}