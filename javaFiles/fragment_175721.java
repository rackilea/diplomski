#version 100
precision mediump float;
uniform sampler2D Tex;
varying vec2 TexCoord;
void main() {
    gl_FragColor = texture2D(Tex, TexCoord);
}