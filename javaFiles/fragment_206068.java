varying vec4 vColor;
varying vec2 vTexCoord;
uniform sampler2D u_texture;   //diffuse map
uniform sampler2D u_normals;   //normal map

const int LIGHT_COUNT = 4;

uniform vec2 resolution;      //resolution of screen
uniform vec3[LIGHT_COUNT] lightPos;      //light position, normalized
uniform vec4[LIGHT_COUNT] lightColor;      //light RGBA -- alpha is intensity
uniform vec4 ambientColor;    //ambient RGBA -- alpha is intensity

void main() {

    vec4 diffuseColor = texture2D(u_texture, vTexCoord);
    vec3 normalMap = texture2D(u_normals, vTexCoord).rgb;
    vec3 N = normalize(normalMap * 2.0 - 1.0);

    float resolutionFactor = resolution.x / resolution.y;

    vec3 diffuse = new vec3(0.0);
    for (int i=0; i<LIGHT_COUNT; i++){
        vec3 lightDir = vec3(lightPos[i].xy - (gl_FragCoord.xy / resolution.xy), lightPos[i].z);
        lightDir.x *= resolutionFactor;
        vec3 L = normalize(lightDir);
        float distance = length(lightDir);
        vec3 attenuation = 1.0 / ( 0.4 + 3.0*distance + (20.0*distance*distance ) );
        diffuse += attenuation * (lightColor[i].rgb * lightColor[i].a) * max(dot(N, L), 0.0);
    }

    //pre-multiply ambient color with intensity
    vec3 ambient = ambientColor.rgb * ambientColor.a;


    //the calculation which brings it all together
    vec3 intensity = min(vec3(1.0), ambient + diffuse); // don't remember if min is critical, but I think it might be to avoid shifting the hue when multiple lights add up to something very bright.
    vec3 finalColor = diffuseColor.rgb * intensity;
    gl_FragColor = vColor * vec4(finalColor, diffuseColor.a);

}