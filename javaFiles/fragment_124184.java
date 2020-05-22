for (int i = 0; i < oynananHamle.length(); i++) {
            char c = oynananHamle.charAt(i);
            //if ((c >= '0' && c <= '9') || c == '.') {
               // continue; // go to next character
             if (Character.isUpperCase(c)) {
                sonuc = "Figür Hamlesi Yapıldı :" + c + " "+i;
                 break;
            }
            if (!(c >= '0' && c <= '9' || c == '.')) {
                sonuc = "Piyon hamlesi yapıldı :" + c + " "+i;
                break;
            }
        }