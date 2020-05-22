myjcombobox.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (myjcombobox.getEditor().getItem().toString().length() < 4) {
                    if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                        f.getToolkit().beep();
                        e.consume();
                    }
                } else { 
                    e.consume();
                }
            }
        });