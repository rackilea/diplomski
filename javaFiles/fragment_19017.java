if (provjera.equals("josip")){
        ulaz.open();
        ulaz.spremi(brojjokera, kolicina);
        brojac= ulaz.procitaj();
        proba.setText("Updated value is "+brojac);
        ulaz.close();

 }else
 {
         proba.setText("Old value is "+brojac);
 }