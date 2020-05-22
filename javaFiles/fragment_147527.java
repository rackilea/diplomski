// Vertex
#version 330

in vec4 a_position;
in vec4 a_color;    // <--- A color value is passed as a vertex attribute
in vec2 a_texCoord0;

out vec4 v_color;
out vec2 v_texCoord0;

uniform mat4 u_projTrans;

void main() {
    v_color = a_color;    // <--- you are sending it to fragment shader
    v_texCoord0 = a_texCoord0;
    gl_Position = u_projTrans * a_position;
}