private class TabSelect implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
        JTabbedPane source = (JTabbedPane) e.getSource();
        if (source.getSelectedComponent() != null) {
            index = source.getSelectedIndex();
            System.out.print(index);
        }
    }
}

private class AddTab implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Slice panel = new Slice();
            panel.setPreferredSize(new Dimension(550, 600));
            String title = "Slice " + String.valueOf(pane.getTabCount());
            pane.insertTab(title, null, panel, null, pane.getTabCount() - 1);
            network_slices.add(panel);
        }
    }

private class AddNetworkFuncitons implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String buttonselected = (String) e.getActionCommand();
            JButton button = new JButton(buttonselected);
            network_slices.get(index).add(button).setVisible(true);
            System.out.print(buttonselected);

        }
    }