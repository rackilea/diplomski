loca_commit = new JButton("Realizar Locação");
loca_commit.setActionCommand("locaCommit");

//...

private class LocaHandler implements ActionListener{
    public void actionPerformed(ActionEvent event){
        String string = "";

        if("locaCommit".equals(event.getActionCommand()))
            string=String.format("Botão Apertado");

        JOptionPane.showMessageDialog(null, string);
}