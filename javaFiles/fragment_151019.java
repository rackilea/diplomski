JTextArea textArea = new JTextArea(...);

MouseListener[] ml = (MouseListener[])textArea.getListeners(MouseListener.class);

for (int i = 0; i < ml.length; i++)
    textArea.removeMouseListener( ml[i] );