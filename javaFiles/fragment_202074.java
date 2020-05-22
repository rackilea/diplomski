//-------------------------------------Changes to Queen Piece and Validates Move----------------------------------------------

    if(!validMove){
        int location=0;
        if(startY ==0){
            location = startX;
        }
        else{
            location  = (startY*8)+startX;
        }
        String pieceLocation = pieceName+".png";
        pieces = new JLabel( new ImageIcon(pieceLocation) );
        panels = (JPanel)chessBoard.getComponent(location);
        panels.add(pieces);
    }
    else{
        if(success){

            if (c instanceof JLabel){
                Container parent = c.getParent();
                parent.remove(0);

                String promoteTo;
                do {
                    promoteTo = (String) JOptionPane.showInputDialog(null,
                        "Promote to:", "Promotion",
                        JOptionPane.QUESTION_MESSAGE, null,
                        new String[]{"Queen", "Bishup", "Knight", "Rook"}, "Queen");
                } while (promoteTo == null);
                String newPiece = null;
                int location = 0;
                if (pieceName.contains("White"))
                {
                    location = 56 + (e.getX()/75);
                    newPiece = "White"+promoteTo;
                }
                else
                {
                    location =  (e.getX()/75);
                    newPiece = "Black"+promoteTo;
                }

                pieces = new JLabel( new ImageIcon(newPiece+".png") );
                parent = (JPanel)chessBoard.getComponent(location);
                parent.add(pieces);
                validate();
                repaint();
            }
        }
        else{
            if (c instanceof JLabel){
                Container parent = c.getParent();
                parent.remove(0);
                parent.add( chessPiece );
            }
            else {
                Container parent = (Container)c;
                parent.add( chessPiece );
            }
            chessPiece.setVisible(true);
        }
    }