public static int suggestRotation(int o, int n){
    //--convert to +0 to +360 range--
    o = normalize(o);
    n = normalize(n);

    //-- required angle change --
    int d1 = n - o;

    //---other (360 - abs d1 ) angle change in reverse (opp to d1) direction--
    int d2 = d1 == 0 ? 0 : Math.abs(360 - Math.abs(d1))*(d1/Math.abs(d1))*-1;

    //--give whichever has minimum rotation--
    if(Math.abs(d1) < Math.abs(d2)){
        return d1;
    }else {
        return d2;
    }

}

private static int normalize(int i){
    //--find effective angle--
    int d = Math.abs(i) % 360;

    if(i < 0){
    //--return positive equivalent--
        return 360 - d;
    }else {
        return d;
    }
}