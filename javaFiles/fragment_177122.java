<script id="draw-shader-vs" type="x-shader/x-vertex">
precision mediump float;
attribute vec3 inPos;
attribute vec3 inNV;
attribute vec2 inTex;
varying float NdotL;
varying vec2 texCoord;

uniform mat4 u_projectionMat44;
uniform mat4 u_viewMat44;
uniform mat4 u_modelMat44;
uniform vec3 u_lightDir;

void main()
{
    vec3  modelNV = mat3( u_modelMat44 ) * normalize( inNV );
    vec3  normalV = mat3( u_viewMat44 ) * modelNV;
    vec3  lightV  = normalize( -u_lightDir );
    NdotL         = max( 0.0, dot( normalV, lightV ) );
    texCoord      = inTex;

    vec4 modelPos = u_modelMat44 * vec4( inPos, 1.0 );
    vec4 viewPos  = u_viewMat44 * modelPos;
    gl_Position   = u_projectionMat44 * viewPos;
}
</script>

<script id="draw-shader-fs" type="x-shader/x-fragment">
precision mediump float;
varying float     NdotL;
varying vec2      texCoord;
uniform sampler2D u_texture;

void main()
{
    vec3 texColor = texture2D( u_texture, texCoord.st ).rgb;
    vec3 lightCol = (0.2 + 0.8 * NdotL) * texColor.rgb;
    gl_FragColor  = vec4( lightCol.rgb, 1.0 );
}
</script>

<body onload="sceneStart();">
    <canvas id="model-canvas" style="border: none;" width="256" height="256"></canvas>
</body>