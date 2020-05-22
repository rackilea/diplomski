public void addMesh(org.joml.Vector3f position, Mesh mesh){
    float[] coords = mesh.getVertices();
    int[] indices = mesh.getIndices();

    if (indices.length > 0) {

        IndexedMesh indexedMesh = new IndexedMesh();
        indexedMesh.numTriangles = indices.length / 3;
        indexedMesh.triangleIndexBase = ByteBuffer.allocateDirect(indices.length*Integer.BYTES).order(ByteOrder.nativeOrder());
        indexedMesh.triangleIndexBase.rewind();
        indexedMesh.triangleIndexBase.asIntBuffer().put(indices);
        indexedMesh.triangleIndexStride = 3 * Integer.BYTES;
        indexedMesh.numVertices = coords.length / 3;
        indexedMesh.vertexBase = ByteBuffer.allocateDirect(coords.length*Float.BYTES).order(ByteOrder.nativeOrder());
        indexedMesh.vertexBase.rewind();
        indexedMesh.vertexBase.asFloatBuffer().put(coords);
        indexedMesh.vertexStride = 3 * Float.BYTES;

        TriangleIndexVertexArray vertArray = new TriangleIndexVertexArray();
        vertArray.addIndexedMesh(indexedMesh);

        boolean useQuantizedAabbCompression = false;
        BvhTriangleMeshShape meshShape = new BvhTriangleMeshShape(vertArray, useQuantizedAabbCompression);
        meshShape.setLocalScaling(new Vector3f(0.5f, 0.5f, 0.5f));

        CollisionShape collisionShape = meshShape;

        CollisionObject colObject = new CollisionObject();
        colObject.setCollisionShape(collisionShape);
        colObject.setWorldTransform(new Transform(new Matrix4f(new Quat4f(0, 0, 0, 1), new Vector3f(position.x, position.y, position.z), 1f)));
        dynamicsWorld.addCollisionObject(colObject);

    } else {
        System.err.println("Failed to extract geometry from model. ");
    }

}