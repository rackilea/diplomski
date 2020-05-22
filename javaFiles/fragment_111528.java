-   public boolean depthTest = true;
+   public boolean depthTest = false;
-   public boolean vertexArray = true, indexArray = true, colorArray = false, textureArray = false, normalArray = false;
+   public boolean vertexArray, indexArray, colorArray, textureArray, normalArray;

static {
+       DEFAULT_3D.depthTest = true;
+       DEFAULT_3D.vertexArray = true;
+       DEFAULT_3D.indexArray = true;
+
+       DEBUG_3D.depthTest = true;
+       DEBUG_3D.vertexArray = true;
+       DEBUG_3D.indexArray = true;
        DEBUG_3D.faceCullingMode = FaceCullingMode.Off;
}