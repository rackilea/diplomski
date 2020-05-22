public static void wrong(final Component component) {
        class MyActionListener implements ActionListener {
            private Timer timer;

            public void setTimer(Timer timer) {
                this.timer = timer;
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                int green = component.getBackground().getGreen();
                int blue = component.getBackground().getBlue();
                component.setBackground(new Color(255, green + 1, blue + 1));
                if (component.getBackground().equals(Color.WHITE)) {
                    if (timer == null) {
                        System.err.println("This sucks, I got no timer");
                    } else {
                        timer.stop();
                    }
                }

            }
        }
        MyActionListener wrongAction = new MyActionListener();
        component.setBackground(Color.RED);
        Timer timer = new Timer(2, wrongAction);
        wrongAction.setTimer(timer);


        timer.start();

    }