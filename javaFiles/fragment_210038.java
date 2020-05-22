public class rMouseListener extends JFrame {
    //...
    private MouseListener mouseListener;

    public rMouseListener() {

        mouseListener = new MouseHandler();
        for(int i = 0; i< 4; i++) {
            jLabel[i].setText(i + " ");
            panel.add(jLabel[i]);
            jLabel[i].addMouseListener(mouseListener);
        }
        //...
    }

    public void addbackMouseListener(JLabel label) {
        label.addMouseListener(mouseListener); 
    }

    //...

    public MouseHandler extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            JLabel label =(JLabel) e.getSource();
            clickCount++;

            /*remove the mouseListener for the label that is clicked*/
            if(clickCount == 1) {
                label.setBackground(Color.red);
                label.setOpaque(true);
                label.removeMouseListener(this);
                mouseRemoved = true;
            }

            /* to verify that the mouseListener for that label is removed after
            first click.*/
            else if(clickCount == 2) {
                label.setBackground(Color.green);
                label.setOpaque(true);
            }

            /*check if the mouseListener is removed.
              add back the mouseListener to the one that is perviously
              removed at clickCount = 1 if it's removed*/
            else if(clickCount == 3) {
                if(mouseRemoved) {
                    addbackMouseListener(label);
                    label.setBackground(Color.black);
                }
            }


        }
    }
}