quest.addActionListener(new DisableButtonActionListener());

            ...

    private class DisableButtonActionListener implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e) {
                        JButton source = (JButton) e.getSource();
                        source.setEnabled(false);
                        source.setBackground(Color.GREEN);
                }
    }