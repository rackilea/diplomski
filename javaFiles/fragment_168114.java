private class Actions implements ActionListener {
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cont) {
            ActionListener[] listeners = ((AbstractButton) cont).getActionListeners();
            System.out.println("number of listeners added to cont: " + listeners.length);

            part1.setVisible(false);
            add(part2, BorderLayout.CENTER);
            part2.setVisible(true);
            Part2();
        }
    }
}