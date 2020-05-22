GeometryArray ge=(GeometryArray)shape.getGeometry();
double[] cc1=new double[3];
ge.getCoordinate(0, cc1);
System.out.println(cc1[0]+" "+cc1[1]+" "+cc1[2]);
ge.getCoordinate(1, cc1);
System.out.println(cc1[0]+" "+cc1[1]+" "+cc1[2]);