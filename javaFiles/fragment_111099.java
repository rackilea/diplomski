@Override
public void actionPerformed(ActionEvent e) {
    Object z = e.getSource(); 
    if(z == bOK) {
        dA = getA();
        dB = getB();
        dC = getC();
        dD = getD();
        System.out.println("1st checkpoint: A " + dA + " B " + dB + " C " + dC + " D " + dD);
        if (oknoFunkcji == null) {
            oknoFunkcji = new OknoFunkcji("Wykres");
        }
        oknoFunkcji.createChart(dA,dB,dC,dD); // added this method 
        oknoFunkcji.setVisible(true);
        //setVisible(false);
    }
    else if (z == bCancel) {
        setVisible(false);          
    }   
}