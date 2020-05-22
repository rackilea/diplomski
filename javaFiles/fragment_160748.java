class MyKeyListener implements KeyListener {
    public void getText()
    {
        StringBuffer sb = new StringBuffer();
        String str = JtextareaTest.jtextArea1.getText();
        sb.append(str);
        JtextareaTest.jtextArea2.setText(sb.toString());
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {
    if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            getText();
        }
    }
}