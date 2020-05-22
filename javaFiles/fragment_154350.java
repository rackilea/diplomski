@Override
public String toString() {
    if(coef ==0){
        return "0";
    }else if(expo ==0){
        return ""+coef;
    }else{
        String pref = coef==1? "": coef==-1?"-":""+coef; 
        String suff = expo>1? "^"+expo:""; 
        return pref+"x"+suff;
    }
}