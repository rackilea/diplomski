button2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JPanel content = new JPanel(new BorderLayout());
            //panel with label and textield
            JPanel base = new JPanel(new BorderLayout());
            base.add(label, Borderlayout.LINE_START);
            base.add(textfield, BorderLayout.LINE_END)
            content.add(base, BorderLayout.PAGE_START

            //panel with label2 and textfield2
            JPanel height = new JPanel(new BorderLayout());
            height.add(label2, BorderLayout.LINE_START);
            height.add(textfield2, BorderLayout.LINE_END);
            content.add(height, BorderLayout.CENTER);

            JPanel forbutton5 = new JPanel();
            forbutton5.add(button5);
            content.add(forbutton5, BorderLayout.PAGE_END);
            panel.add(content);
            panel.revalidate();
            panel.repaint();
            label.setText("Geef de basis van de driehoek in cm: ");
            label2.setText("Geef de hoogte van de driehoek in cm: ");
        }
    });