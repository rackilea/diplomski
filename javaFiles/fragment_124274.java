private final MouseListener bildYtaLyss = new BildYtaLyss();

private class NyPlatsLyss implements ActionListener{
  public void actionPerformed(ActionEvent e) {
    bildYta.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    bildYta.addMouseListener(bildYtaLyss);
    EscLyss escLyss = new EscLyss();
    bildYta.addKeyListener(escLyss);
    bildYta.requestFocusInWindow();
    enableOperations(false);
  }
}

private class EscLyss extends KeyAdapter{
  public void keyPressed(KeyEvent e){
    if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
      bildYta.setCursor(Cursor.getDefaultCursor());
      bildYta.removeMouseListener(bildYtaLyss);
      bildYta.removeKeyListener(this);
      enableOperations(true);
    }
  }
}