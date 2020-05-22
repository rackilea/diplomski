#version 330 core

in vec4 position;
in vec4 color;

uniform mat4 model;
uniform mat4 projection;
uniform mat4 view;

out vec4 vertexColor;

void main() {
    // Just pass the color down to the fragment shader
    vertexColor = color;

    // Calculate the Model, View, Projection matrix into one ( in this order, right to left )
    mat4 mvp = projection * view * model;

    // Calculate the position of the vertex
    gl_Position = mvp * vec4(position.xyz,1);
}