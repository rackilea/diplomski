//CLASS B
public void setDados(ArrayList<String> dados) {
    DefaultListModel model = new DefaultListModel();
    for (String s : dados) {
        model.addElement(s);
    }
    jList.setModel(model);
}

//CLASS A
private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {                                      
    ArrayList<String> dados = new ArrayList<String>();
    dados.add(jList1.getSelectedValue());
    //...
    dados.add(jList13.getSelectedValue());
    TelaRBC tela_rbc = new TelaRBC();

    tela_rbc.setDados(dados); //<<<<<<<<<< The difference.

    tela_rbc.setVisible(true);
    System.out.print(dados);
    dispose();
}