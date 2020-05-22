field.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Reset
            for (int order = 0; order < labelsArray.size(); order++) {
                JLabel label = labelsArray.get(order);
                labelsPanel.setComponentZOrder(label, order);
            }

            String text = field.getText();
            for (JLabel label : labelsArray) {
                if (label.getText().equals(text)) {
                    labelsPanel.setComponentZOrder(label, 0);
                    break;
                }
            }

            labelsPanel.revalidate();
            labelsPanel.repaint();
        }
    });