uniform mat4 u_viewMatrix;

void main()
{
    // [...]

    vec3 lightPosView = vec3(u_viewMatrix * vec4(u_lightPosition.xyz, 1.0)); 
    vec3 lightVector  = normalize(u_lightPosition - modelViewVertex);

    // [...]
}