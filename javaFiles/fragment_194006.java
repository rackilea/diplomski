private void HitungMouseClicked(java.awt.event.MouseEvent evt) {                                    
     nilai1 = Integer.parseInt(angka1.getText());
     nilai2=Integer.parseInt(angka2.getText());
     operator=operator1.getText();

     double jawaban=0;
    if(operator.equalsIgnoreCase("+"))
        jawaban=nilai1+nilai2;
    else if(operator.equalsIgnoreCase("-"))
        jawaban=nilai1-nilai2;
    else if(operator.equalsIgnoreCase("*"))
        jawaban=nilai1*nilai2;
    else if(operator.equalsIgnoreCase("/"))
        jawaban=nilai1/nilai2;            
    String hasil=Double.toString(jawaban);

    txtHasil.setText(hasil);

}