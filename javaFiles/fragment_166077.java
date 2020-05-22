private int odd;
private int even;

//....
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    int a = Integer.parseInt(txt1.getText());
    if (a%2==0)
    {
      even++;
      lbleven.setText(""+even);
    }
    else
    {
      odd++;
      lblodd.setText(""+odd);
    }
}