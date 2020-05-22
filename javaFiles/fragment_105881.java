precision mediump float;

varying vec4 v_color;
varying vec2 v_texCoords;
uniform sampler2D u_texture;
uniform mat4 u_projTrans;

bool equals(float a, float b) {
    return abs(a-b) < 0.0001;
}

bool isWhiteShade(vec4 color) {
    return equals(color.r, color.g) && equals(color.r, color.b);
}

void main() {
    vec4 color = texture2D (u_texture, v_texCoords) * v_color;
    if(isWhiteShade(color)) {
        color *= vec4(0, 0, 1, 1);
    }
    else {
        color *= vec4(0, 0, 0, 1);
    }
    gl_FragColor = color;
}