public void mouseClicked(java.awt.event.MouseEvent evt)
    {
        if (board.get(ESide.tleft).booleanValue() == false) {
            topLeft.setText("X");
            board.put(ESide.tleft, true);
        }
    }