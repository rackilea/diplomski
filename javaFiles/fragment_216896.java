JPanel ui = new JPanel() {

            @Override
            public Dimension getPreferredSize() {

                return new Dimension(window.getContentPane().getSize().width, window.getContentPane().getSize().height / 4);

            }
        };