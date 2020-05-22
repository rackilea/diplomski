precision mediump float;

varying LOWP vec4 v_color;
varying vec2 v_texCoord;

uniform sampler2D s_texture;
uniform sampler2D s_mask;

void main()
{
    vec3  texCol  = texture2D( s_texture, v_texCoord ).rgb;
    float maskCol = texture2D( s_mask, v_texCoord ).r;
    vec3 finalCol = s_texture.rgb * mix( v_color.rgb, vec3(1.0), maskCol );
    gl_FragColor  = vec4( finalCol, 1.0 );
}