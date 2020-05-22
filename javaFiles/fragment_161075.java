JButton btnRefreshAllPlayers = new JButton("Refresh");

btnRefreshAllPlayers.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent arg0) {

        TableModel model = new PlayerTableModel(FileHandler.getCompletedPlayers());
        table.setModel(model);

    }

});