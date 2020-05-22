public static final String fragmentExternalShaderCode =
        "#extension GL_OES_EGL_image_external : require\n" +
                "precision mediump float;" +
                "uniform samplerExternalOES sTexture;" +
                "varying vec2 vTexCoordinate;" +

                "void main() {" +
                "  gl_FragColor = texture2D(sTexture, vTexCoordinate);" +
                "}";