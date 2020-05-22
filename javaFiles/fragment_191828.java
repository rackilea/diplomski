pForm4 = null;
    mn=pForm1.getCount();
    for(int k=0;k<def.size();k++){
        pForm2=null;
        pForm2=(Form)def.get(k);
        if(pForm1.getPhase() == pForm2.getPhase()){
            mn = mn + pForm2.getCount();
        }
    }
    pForm4.setPhase(pForm.getPhase());