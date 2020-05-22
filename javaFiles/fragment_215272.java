public static void removeDuplicates(){
    ArrayList<Slips> newRay = new ArrayList<Slips>();
    for(Slips s : ALSlips){
        boolean hasAlready = false;
        for(Slips d: newRay){
            if(d.personID == s.personID){
                d.product1Sold += s.product1Sold;
                d.product2Sold += s.product2Sold;
                d.product3Sold += s.product3Sold;
                d.product4Sold += s.product4Sold;
                d.numberOfSold += s.numberOfSold;
                d.performance += s.performance;
                hasAlready = true;
            }
        }
        if(!hasAlready){
            newRay.add(s);
        }
    }
    ALSlips = newRay;
}