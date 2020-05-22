if(aveRP[0] > 0){
    for(int i = 0 ; i < 100; i++){
        double a = r.nextGaussian() * 0.3 + aveRP[0];
        if( !(a < 0 || a > 1) ){ relinp.add(a);}
    }
}