for (int i=1; i <= incount; i++) {   

    String ord = getString("BqlOrd" + i);

    Bnum = (BStatusNumeric)get("Num"+i);
    Bavg = (BStatusNumeric)get("Avg"+i);
    Bmin = (BStatusNumeric)get("Min"+i);           
    Bmax = (BStatusNumeric)get("Max"+i); 
    Bdefault = (BStatusNumeric)get("Default"+i); 
}