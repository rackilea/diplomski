String myStr = "PRODUCTION PERIOD 15 DAYS VALIDITY 30 DAYS TOTAL 2.117 BOXES VOLUME 231,78 m 3 NET WEİGHT 10.588,50 kg GROSS WEİGHT 11.700,00 kg";
    String[] words = myStr.split(" ");
    for (int i = 0; i < words.length; i++){
        if (words[i].toLowerCase().equals("validity")){
            System.out.println("Validity is " + words[i + 1]);
        }

        if (words[i].toLowerCase().equals("total")){
            System.out.println("Total is " + words[i + 1]);
        }

        if (words[i].toLowerCase().equals("volume")){
            System.out.println("Volume is " + words[i + 1]);
        }
    }