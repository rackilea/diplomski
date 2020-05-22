public GObject(Point3D[] v, Face[] f){
    setV(v);
    face = f;
}

public GObject(String fileName){
    try{
       ...//read contents of file and store in an array
       setV(new Point3D[numOfVertices]);
    } catch(Exception e){
       System.out.println("Can't read file " + e.getMessage());
    }
}

private void setV(Point3D[] v) {
    vertex = v;
}