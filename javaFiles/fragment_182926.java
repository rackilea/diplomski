// 
  // create fragment Shader
  int fragShader = gl4.glCreateShader(GL4.GL_FRAGMENT_SHADER);
  gl4.glShaderSource(fragShader, 1, 
    new String[]{"#version 420 \n"
    +"out vec4 fragColor;"
    +"void main(void) {"
    +"fragColor = vec4(0.2, 0.2, 0.5, 1.0);}" }, null);
    gl4.glCompileShader(fragShader);