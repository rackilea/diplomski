params.setPeriodiciteI(Periode.ANNUELLE);
 params.setPeriodiciteK(Periode.ANNUELLE);

 if(reallyNecessary){           // see? way more dynamic :)
     params.setTauxNDecimal(2);
     params.setPeriodeCalculInterets(PeriodeCalculInterets.PAR_PERIODE);
 }else{
     params.setBaseCalcul(BaseCalcul.BC_360360);
 }