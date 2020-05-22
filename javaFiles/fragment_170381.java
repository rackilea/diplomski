org.onvif.ver10.schema.Polygon op = new org.onvif.ver10.schema.Polygon();

    for (int i = 1; i <= p.npoints; i++) {
        org.onvif.ver10.schema.Vector MyVector = new Vector(); 
        MyVector.setX((float)p.xpoints[i-1]);
        op.getPoint().add(MyVector);
        IJ.log("Vector X Elements "+i+" :"+ MyVector.getX());

    }