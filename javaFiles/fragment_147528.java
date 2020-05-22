// Fragment
#version 330

in vec4 v_color;    // <--- coming from vertex buffer
in vec2 v_texCoord0;

out vec4 outColor;

uniform vec4 color;
uniform sampler2D u_texture;

void main() {
    // This is always true for some reason...
    if(v_color.r == 1.0) {   // <--- and then checking this vertex attribute color 
        outColor = color;    //      instead of what you send from texture
    } else {
        ...
    }
}