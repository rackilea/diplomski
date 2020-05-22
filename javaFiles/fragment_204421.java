confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean buttonClicked = false;
                for (int i = 0; i < 30; i++) {
                    if (ButtonList[i].isSelected()) {
                        buttonClicked = true;
                        System.out.println(i);
                    }
                }
                if (!buttonClicked) {
                    System.out.println("No button is clicked");
                }
            }

        });