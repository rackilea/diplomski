public void setvar(String varsent) {
        cost = varsent;
        try {
            imageIcon.setImage(BackEnd.getQRCodeImage(cost));
            lblQRCode.setIcon(imageIcon);
            lblstatus.setText("Amount for " + cost);
            System.out.println(BackEnd.gaddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }