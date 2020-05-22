private static void showReceipt(double postage, double certifiedFee,
        double restrictedFee, double returnReceiptFee, String nameString,
        String addressString, String cityString) {
    // TODO Auto-generated method stub
    DecimalFormat fmt = new DecimalFormat(" $0.00");
    double certifiedMailFee = 0;
    double restrictedDelivery = 0;
    String outputString = "U.S. POSTAL SERVICE\nCERTIFIED MAIL RECEIPT\n---------------------\nPostage" + 
            fmt.format(postage) + 
            "\nCertified Mail Fee" + fmt.format(certifiedMailFee) + 
            "\nRestricted Delivery Fee" + fmt.format(restrictedDelivery) + 
            "\nReturn Receipt Fee" + fmt.format(returnReceiptFee) + 
            "\nTotal Postage & Fees" + fmt.format(postage + certifiedMailFee + restrictedDelivery + returnReceiptFee) + 
            "\n----------------------------" + 
            "\nSend to:" + 
            "\n" + nameString + 
            "\n----------------------------" + 
            "\nStreet, Apt No., or PO Box No." + 
            "\n" + addressString + 
            "\n----------------------------" + 
            "\nCity, State, ZIP+4®" + 
            "\n" + cityString;

    JOptionPane.showMessageDialog(null, 
            outputString, 
            "Certified Mail Receipt", 
            1, 
            null);

}