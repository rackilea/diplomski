#version 100
uniform vec2 ScaleFact;
attribute vec2 Position;
varying vec2 TexCoord;
void main() {
    gl_Position = vec4(ScaleFact * Position, 0.0, 1.0);
    TexCoord = 0.5 * Position + 0.5;
}