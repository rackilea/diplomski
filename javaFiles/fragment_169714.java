button2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //panel with label and textield
            JPanel base = new JPanel(new BorderLayout());
            base.add(label, Borderlayout.LINE_START);
            base.add(textfield, BorderLayout.LINE_END)
            panel.add(base, BorderLayout.PAGE_START);//top of the page this may interfere with your three buttons I don't know where you are in your layout structure

            //panel with label2 and textfield2
            JPanel height = new JPanel(new BorderLayout());
            height.add(label2, BorderLayout.LINE_START);
            height.add(textfield2, BorderLayout.LINE_END);
            panel.add(height, BorderLayout.CENTER);

            //button5 doesn't need a panel of it's own as it's only one component
            panel.add(button5, BorderLayout.PAGE_END);
            panel.revalidate();
            panel.repaint();
            label.setText("Geef de basis van de driehoek in cm: ");
            label2.setText("Geef de hoogte van de driehoek in cm: ");
        }
    });