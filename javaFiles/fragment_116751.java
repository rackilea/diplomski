public void PostCodeSearch() {
    ReadingFromAFile();
    String StrPstCd = PstCd.getText();

    for (int i = 0; i < twod.length; i++) {
        for (int x = 0; x < twod[i][3].length; x++) {

            if (StrPstCd.length == 3  && twod[i][3].length <= x + 3) {
                String PstCdSub = twod[i][3].substring(x, x + 3);
                if (StrPstCd.equals(PstCdSub)) {
                    text.append("Price = " + twod[i][1] + " " + "Date of Sale: " + twod[i][2] + " " + "Postcode: " + twod[i][3] + "\n");
                }
            } 

            else if(StrPstCd.length == 4 && twod[i][3].length <= x + 4) {
                String PstCdSub = twod[i][3].substring(x, x + 4);
                if (StrPstCd.equals(PstCdSub)) {
                    text.append("Price = " + twod[i][1] + " " + "Date of Sale: " + twod[i][2] + " " + "Postcode: " + twod[i][3] + "\n");
                }
            }

        }
    }
}