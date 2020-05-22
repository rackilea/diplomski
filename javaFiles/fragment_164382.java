private void removePieces() {
        for(int i = 0; i < 64; i ++) {   
            if(chessBoard.getComponent(i) instanceof JPanel) {
            JPanel c = (JPanel)chessBoard.getComponent(i);
            c.removeAll();
            c.revalidate();
            c.repaint();
            }
        }
    }