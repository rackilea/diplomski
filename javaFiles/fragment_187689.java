ActionListener priceListener = new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
            if (e.getSource() == poolPrice) { 
                tubLabel.setEnabled(false); 
                tubField.setEnabled(false); 
                // Re-enable the previously disabled labels
                poolLabel.setEnabled(true);
                poolField.setEnabled(true);
                messageArea.setVisible(false); 
            } else if (e.getSource() == tubPrice) { 
                poolLabel.setEnabled(false); 
                poolField.setEnabled(false); 
                // Re-enable disabled labels
                tubLabel.setEnabled(true);
                tubField.setEnabled(true);

                messageArea.setVisible(false); 
            } 
            } 
        };