<script id="draw-shader-vs" type="x-shader/x-vertex">
precision mediump float;

attribute vec2 inPos;

void main()
{
    gl_Position = vec4( inPos.xy, 0.0, 1.0 );
}
</script>

<script id="draw-shader-fs" type="x-shader/x-fragment">
precision mediump float;

uniform vec2 viewportDimensions;
uniform float minX;
uniform float maxX;
uniform float minY;
uniform float maxY;

vec3 hsv2rgb(vec3 c){
    vec4 K = vec4(1.0, 2.0 / 3.0, 1.0 / 3.0, 3.0);
    vec3 p = abs(fract(c.xxx + K.xyz) * 6.0 - K.www);
    return c.z * mix(K.xxx, clamp(p - K.xxx, 0.0, 1.0), c.y);
}

void main()
{
  float x = gl_FragCoord.x;
  float y = gl_FragCoord.y;

  vec2 c = mix(vec2(minX, minY), vec2(maxX, maxY), gl_FragCoord.xy / viewportDimensions.xy);
  vec2 z = c;

  float limit = 64.0;
  float iterations = 0.0;
  for(int i = 0; i < 64; i++){
      float t = 2.0 * z.x * z.y + c.y;
      z.x = z.x * z.x - z.y * z.y + c.x;
      z.y = t;

      if(z.x * z.x + z.y *z.y > 4.0){
          break;
      }

      iterations += 1.0;
  }
  float itRGB = iterations/limit;
  vec3 hsv = vec3(itRGB, 1.0, 1.0);
  vec3 rgb = hsv2rgb(hsv);
  gl_FragColor = vec4(rgb, 1);
}
</script>

<canvas id="ogl-canvas" style="border: none"></canvas>