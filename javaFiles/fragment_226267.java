jButton1.addActionListener(new java.awt.event.ActionListener() {
@Override
public void actionPerformed(java.awt.event.ActionEvent evt) {
if(idprod!=0)
{
    montanttva1 = prixtotalttc - prixtotalht;
    int row = tableaupan.getRowCount();

    for (int i = 0; i < row; i++){
        if(tableaupan.getValueAt(i,0).equals(idprod))
        {
             OptionPane.showMessageDialog(null, "Product is already in the basket !","Error",JOptionPane.ERROR_MESSAGE);     
             return;                       
        }
    }
modele.addCaisse(new Caisse(idprod,JTitre.getText().toString(),cqte,prixunittcc,prixht,montanttva1,prixtotalht,prixtotalttc,typetva,tva));
}
else
{
    JOptionPane.showMessageDialog(null, "Nothing to add to basket !", "Errorr",JOptionPane.ERROR_MESSAGE);
}
}
});