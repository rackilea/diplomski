#version 300 es

in  vec3 vPosition;
in  vec4 vColor;
out vec4 vPassColor;

void main() {
    gl_Position = vec4(vPosition, 1.0);
    vPassColor  = vColor;
}