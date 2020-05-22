timer = new Timer (10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) 
        {
            Point loc = getLocationOnScreen();
            setPreferredSize(new Dimension(sizeW, sizeH));
            pnlAccDetails.setPreferredSize(new Dimension(sizeW, sizeH));
            repaint();
            revalidate();
            pack();

            sizeW += 3;
            sizeH += 2;
            if (toggle)
            {
                setLocation((int)(loc.getX() - 0.75), (int)(loc.getY() - 0.5));
                toggle = false;
            }
            else
            {
                toggle = true;
            }

            if (sizeW == 750 && sizeH == 500)
            {
                timer.stop();
            }
        }
    });

    timer.start();