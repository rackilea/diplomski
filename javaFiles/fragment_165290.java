public static int[] getIntermediatePoint(
        int startLatMicroDeg,
        int startLonMicroDeg,
        int endLatMicroDeg,
        int endLonMicroDeg,
        double t // How much of the distance to use, from 0 through 1
    ){
        // Convert microdegrees to radians
        double alatRad=Math.toRadians((double)startLatMicroDeg/1000000);
        double alonRad=Math.toRadians((double)startLonMicroDeg/1000000);
        double blatRad=Math.toRadians((double)endLatMicroDeg/1000000);
        double blonRad=Math.toRadians((double)endLonMicroDeg/1000000);
        // Calculate distance in longitude
        double dlon=blonRad-alonRad;
        // Calculate common variables
        double alatRadSin=Math.sin(alatRad);
        double blatRadSin=Math.sin(blatRad);
        double alatRadCos=Math.cos(alatRad);
        double blatRadCos=Math.cos(blatRad);
        double dlonCos=Math.cos(dlon);
        // Find distance from A to B
        double distance=Math.acos(alatRadSin*blatRadSin +
                                  alatRadCos*blatRadCos *
                                  dlonCos);
        // Find bearing from A to B
        double bearing=Math.atan2(
            Math.sin(dlon) * blatRadCos,
            alatRadCos*blatRadSin -
            alatRadSin*blatRadCos*dlonCos);
        // Find new point
        double angularDistance=distance*t;
        double angDistSin=Math.sin(angularDistance);
        double angDistCos=Math.cos(angularDistance);
        double xlatRad = Math.asin( alatRadSin*angDistCos +
                                   alatRadCos*angDistSin*Math.cos(bearing) );
        double xlonRad = alonRad + Math.atan2(
            Math.sin(bearing)*angDistSin*alatRadCos,
            angDistCos-alatRadSin*Math.sin(xlatRad));
        // Convert radians to microdegrees
        int xlat=(int)Math.round(Math.toDegrees(xlatRad)*1000000);
        int xlon=(int)Math.round(Math.toDegrees(xlonRad)*1000000);
        if(xlat>90000000)xlat=90000000;
        if(xlat<-90000000)xlat=-90000000;
        while(xlon>180000000)xlon-=360000000;
        while(xlon<=-180000000)xlon+=360000000;
        return new int[]{xlat,xlon};
    }