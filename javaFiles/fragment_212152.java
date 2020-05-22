void main() {
    gl_Position = transform * position;
    vec3 ecPosition = vec3(modelview * position);
    vec3 ecNormal = normalize(normalMatrix * normal);

    vertColor = vec4(0.0);
    for (int i=0; i < 2; ++i)
    {
        vec3 direction = normalize(lightPosition[i].xyz - ecPosition);
        float intensity = max(0.0, dot(direction, ecNormal)); 
        vertColor += vec4(intensity, intensity, intensity, 1) * color;
    }
}