#version 150

varying vec4 vertColor; //Just to send the color data to the fragment shader

uniform float tx; //Passed by the Java program to ensure the terrain curvature 
                  //is sinked by with player's movement, this value is usually 
                  //in the "lookThroughCamera" method where you handle the game 
                  //world's translation when the player moves

void main(void) {
    float v0 = gl_Vertex[1] - pow((gl_Vertex[0] + tx) / 64, 2); //this will be the new y-value for the vertex. 
                                                                   //It takes the original y-value and subtracts 
                                                                   //the absolute value of the x-value plus the offset 
                                                                   //on the x-axis of the player divided by 64 all to 
                                                                   //the power of 2. The division by 64 levels the 
                                                                   //curve out enough so it looks acceptable

    vec4 pos = vec4(gl_Vertex[0], v0, gl_Vertex[2], gl_Vertex[3]); //create the new position with the changed y-value
    gl_Position = gl_ModelViewProjectionMatrix * pos; //multiply it by your projection and modelview matrices
    vertColor = gl_Color.argb; //more color stuff that has nothing to do with the rest
}