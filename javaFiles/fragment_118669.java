GrupaArtikala[]grupaArtikala=parser.getObjektiArtikli();
        int length = grupaArtikala.length;
        Object[][] data = new Object[length][4];
        for(int i=0;i<length;i++){
            GrupaArtikala temp = grupaAtrikala[i];
            data[i][0] = temp.getId();
            data[i][1] = temp.getSifra();
            //add the rest of your attributes
        }