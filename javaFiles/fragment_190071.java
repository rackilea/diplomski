// There are 3 floats needed for each vertex (x,y,z)
int bufferSize = vertices.size() * 3 * Float.SIZE;
FloatBuffer verticesBuffer = ByteBuffer.allocateDirect( bufferSize ).order( ByteOrder.nativeOrder() ).asFloatBuffer();

// Copy the values from the list to the direct float buffer
for ( Vector3f v : vertices )
    verticesBuffer.put( v.x ).put( v.y ).put( v.z );