public void mouseEntered(MouseEvent e) {
                    ((JPanel)e.getSource()).setBackground(Color.BLACK);
                    //the index here is the error
                    revalidate();
                    repaint();
                }