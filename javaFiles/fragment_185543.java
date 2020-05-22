double xPostion = (124 - Math.abs(aVertex.getLongitude()));
        xPostion = xPostion / 57;           
        xPostion = xPostion * this.myWidth;
 double yPostion = 49 - aVertex.getLatitude();
        yPostion = yPostion / 25;
        yPostion = yPostion * this.myHeight ;