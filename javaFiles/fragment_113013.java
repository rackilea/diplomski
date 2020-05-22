int v = gl.glCreateShader(GL.GL_VERTEX_SHADER);
int f = gl.glCreateShader(GL.GL_FRAGMENT_SHADER);

BufferedReader brv = new BufferedReader(new FileReader("vertexshader.glsl"));
String vsrc = "";
String line;
while ((line=brv.readLine()) != null) {
  vsrc += line + "\n";
}
gl.glShaderSource(v, 1, vsrc, (int[])null);
gl.glCompileShader(v);

BufferedReader brf = new BufferedReader(new FileReader("fragmentshader.glsl"));
String fsrc = "";
String line;
while ((line=brf.readLine()) != null) {
  fsrc += line + "\n";
}
gl.glShaderSource(f, 1, fsrc, (int[])null);
gl.glCompileShader(f);

int shaderprogram = gl.glCreateProgram();
gl.glAttachShader(shaderprogram, v);
gl.glAttachShader(shaderprogram, f);
gl.glLinkProgram(shaderprogram);
gl.glValidateProgram(shaderprogram);

gl.glUseProgram(shaderprogram);