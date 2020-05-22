b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            if (b.isSelected())
                clicks++;
            else
                clicks--;
        }
    });
}