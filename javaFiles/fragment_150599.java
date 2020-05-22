Beginner implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                    JButton source = (JButton) e.getSource();
                    source.setEnabled(false);
                    source.setBackground(Color.GREEN);
            }

            ...

            quest.addActionListener(this);

}