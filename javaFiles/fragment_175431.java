jrbLeft.addActionListener(
        new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jtfMessage.setHorizontalAlignment(SwingConstants.LEFT);
                jrbCenter.setSelected(false);
                jrbRight.setSelected(false);
                jtfMessage.setColumns(Integer.parseInt(jtfColumn.getText()));
                p1.revalidate();
                SwingUtilities.getWindowAncestor(p1).pack();
                SwingUtilities.getWindowAncestor(p1).setLocationRelativeTo(null);
            }
        }
);