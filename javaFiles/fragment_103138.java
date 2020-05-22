for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                int tx = x;
                int ty = y;
                buttons[y][x] = new JButton();
                board.add(buttons[y][x]);
                buttons[y][x].setBorderPainted(false);

                //color buttons in the checkerboard pattern
                if ((y + x) % 2 != 0) {
                    buttons[y][x].setBackground(new Color(201, 166, 113));
                } else {
                    buttons[y][x].setBackground(Color.WHITE);
                }

                //Add event listener
                ActionListener buttonListener = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        pressedButton(ty, tx);
                    }
                };
                buttons[y][x].addActionListener(buttonListener);

            }
        }