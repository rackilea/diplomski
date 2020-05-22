#version 300 es
precision mediump float;

in  vec4 vPassColor;
out vec4 fragColor;

void main() {
    fragColor = vPassColor;
}