// Create new array, big enough to hold all vertices
        depthArray = new float[xyzIj.xyzCount * 3];
        xyzIj.xyz.get(depthArray);

        // Create Vertices
        Vector3f[] vertices = new Vector3f[xyzIj.xyzCount];
        for(int i=0; i<xyzIj.xyzCount; i++) {
            vertices[i] = new Vector3f(
                depthArray[i*3],
                depthArray[i*3+1], 
                depthArray[i*3+2]);
        }