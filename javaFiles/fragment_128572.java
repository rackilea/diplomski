for(OPV=230;OPV<245;OPV++) {
    for(IKW=1.3;IKW<=2.9;IKW+=0.1) {
        for(OKW=0.01;OKW<0.50;OKW+=0.01) {
            for(OPI=0.05;OPI<0.50;OPI+=0.01) {
                System.out.println(OPV + " " + IKW + " " + OKW + " " + OPI);
            }
        }
    }
}