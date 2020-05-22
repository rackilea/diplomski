public GObject(String fileName){
    this(new Point3D[numOfVertices], new Face[5]); // `5` is just for example.

    try{
       ...//read contents of file and store in an array
       Point3D[] vertices = new Point3D[numOfVertices];

    } catch(Exception e){
       System.out.println("Can't read file " + e.getMessage());
    }
}