@Override 
public void sendXMLData(String adrs, String cdpostal, String pays, String tel, String fx, String web) { 

    adresse = adrs + cdpostal + pays; 
    telephone = tel; 
    fax = fx; 
    website = web; 
    txtAdresse.setText(adresse); 
    txtTel.setText(telephone); 
    txtFax.setText(fax); 
    txtWeb.setText(website); 
}