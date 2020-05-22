NumberFormat nf = NumberFormat.getInstance(Locale.GERMAN);
    nf.setMaximumFractionDigits(2);
    nf.setMinimumFractionDigits(2);


    try {
        double dSize = nf.parse(bottleSize.getValue()).doubleValue();
        double dPrice = nf.parse(txfBottlePrice.getText()).doubleValue();
        double newPrice = dPrice * dSize;
        txfPriceLiter.setText(nf.format(newPrice));
    } catch (java.text.ParseException ex) {
       Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
    }