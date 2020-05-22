uniform vec3 u_lightModelPosition; 

void main()
{
    mat3 normalMat       = inverse(transpose(mat3(u_mvMatrix)));
    vec3 modelViewNormal = normalMat * a_normal;
    vec3 modelViewVertex = vec3(u_mvMatrix * a_position);
    vec3 modelViewLight  = vec3(u_mvMatrix * vec4(u_lightModelPosition, 1.0));

    vec3 lightVector = normalize(modelViewLight - modelViewVertex);

    // [...]
}