JButton[] _PlayerButton = new JButton[4];
    for (int i = 0; i < _PlayerButton.length; i++) {
        final int FinalI = i;
        _PlayerButton[i] = new JButton(_PlayerButtonImage[i]);
        _MainMenu.add(_PlayerButton[i]);
        _PlayerButton[i].setOpaque(false);
        _PlayerButton[i].setPreferredSize(new Dimension(271, 123));
        _PlayerButton[i].setContentAreaFilled(false);
        _PlayerButton[i].setBorder(BorderFactory.createEmptyBorder());

        _PlayerButton[i].addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                _PlayerButton[FinalI].setBorder(BorderFactory.createLoweredBevelBorder());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                _PlayerButton[FinalI].setBorder(BorderFactory.createEmptyBorder());
            }
        });
    }