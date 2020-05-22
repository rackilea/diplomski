#version 120
uniform sampler2D myTexture;

void main()
{
    gl_FragColor = vec4(0.0);
    vec4 texColor = texture2D(myTexture, gl_TexCoord[0]); //Assuming you're using texture coordinate 0.
    if(texColor.a < 1.0)
        gl_FragColor = vec4(1.0,0,0,1.0);
}