Original:
sampler2d texture;
varying vec2 uv;
void main()
{
    vec4 color = texture2D(texture, uv);
}

Array of samplers:
sampler2d texture[32];
varying vec2 uv;
varying float layer;

void main()
{
    vec4 color = texture2D(texture[layer], uv);
}

Texture Array version:
sampler2dArray texture;
varying vec2 uv;
varying float layer;

void main()
{
    vec4 color = texture3D(texture, vec3(uv, layer));
}