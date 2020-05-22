public void actionPerformed(ActionEvent arg0) {

 double strtblnc; 
 double dpst; 
 double wthdrw;

 String sTxt = txt.getText();
 String sTxt2 = txt2.getText();
 String sTxt3 = txt3.getText();

 if(sTxt.isEmpty())
     sTxt = "0";

 if(sTxt2.isEmpty())
     sTxt2 = "0";

 if(sTxt3.isEmpty())
     sTxt3 = "0";


 dpst = Double.parseDouble(sTxt2);//parses deposit;
 strtblnc  = Double.parseDouble(sTxt); //parses starting balance;
 wthdrw = Double.parseDouble(sTxt3); //parses withdraw;

 Balance = Balance + strtblnc + dpst - wthdrw;
 balance.setText("New Balance    " + Balance);    
}