public static final String vertexDefaultShaderCode =
        "uniform mat4 uVPMatrix;" +
                "uniform mat4 uModelMatrix;" + // uniform = input const
                "attribute vec3 aPosition;" +  // attribute = input property different for each vertex
                "attribute vec2 aTexCoordinate;" +
                "varying vec2 vTexCoordinate;" +// varying = output property different for each pixel

                "void main() {" +
                "vTexCoordinate = aTexCoordinate;" +
                "gl_Position = uVPMatrix * uModelMatrix * vec4(aPosition,1.0);" +
                "}";