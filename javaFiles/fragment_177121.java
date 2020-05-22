glArrayType = typeof Float32Array !="undefined" ? Float32Array : ( typeof WebGLFloatArray != "undefined" ? WebGLFloatArray : Array );

function IdentityMat44() {
  var m = new glArrayType(16);
  m[0]  = 1; m[1]  = 0; m[2]  = 0; m[3]  = 0;
  m[4]  = 0; m[5]  = 1; m[6]  = 0; m[7]  = 0;
  m[8]  = 0; m[9]  = 0; m[10] = 1; m[11] = 0;
  m[12] = 0; m[13] = 0; m[14] = 0; m[15] = 1;
  return m;
};

function RotateAxis(matA, angRad, axis) {
    var aMap = [ [1, 2], [2, 0], [0, 1] ];
    var a0 = aMap[axis][0], a1 = aMap[axis][1]; 
    var sinAng = Math.sin(angRad), cosAng = Math.cos(angRad);
    var matB = new glArrayType(16);
    for ( var i = 0; i < 16; ++ i ) matB[i] = matA[i];
    for ( var i = 0; i < 3; ++ i ) {
        matB[a0*4+i] = matA[a0*4+i] * cosAng + matA[a1*4+i] * sinAng;
        matB[a1*4+i] = matA[a0*4+i] * -sinAng + matA[a1*4+i] * cosAng;
    }
    return matB;
}

function Cross( a, b ) { return [ a[1] * b[2] - a[2] * b[1], a[2] * b[0] - a[0] * b[2], a[0] * b[1] - a[1] * b[0], 0.0 ]; }
function Dot( a, b ) { return a[0]*b[0] + a[1]*b[1] + a[2]*b[2]; }
function Normalize( v ) {
    var len = Math.sqrt( v[0] * v[0] + v[1] * v[1] + v[2] * v[2] );
    return [ v[0] / len, v[1] / len, v[2] / len ];
}

var Camera = {};
Camera.create = function() {
    this.pos    = [0, 1.5, 0.0];
    this.target = [0, 0, 0];
    this.up     = [0, 0, 1];
    this.fov_y  = 90;
    this.vp     = [800, 600];
    this.near   = 0.5;
    this.far    = 100.0;
}
Camera.Perspective = function() {
    var fn = this.far + this.near;
    var f_n = this.far - this.near;
    var r = this.vp[0] / this.vp[1];
    var t = 1 / Math.tan( Math.PI * this.fov_y / 360 );
    var m = IdentityMat44();
    m[0]  = t/r; m[1]  = 0; m[2]  =  0;                              m[3]  = 0;
    m[4]  = 0;   m[5]  = t; m[6]  =  0;                              m[7]  = 0;
    m[8]  = 0;   m[9]  = 0; m[10] = -fn / f_n;                       m[11] = -1;
    m[12] = 0;   m[13] = 0; m[14] = -2 * this.far * this.near / f_n; m[15] =  0;
    return m;
}
Camera.LookAt = function() {
    var mz = Normalize( [ this.pos[0]-this.target[0], this.pos[1]-this.target[1], this.pos[2]-this.target[2] ] );
    var mx = Normalize( Cross( this.up, mz ) );
    var my = Normalize( Cross( mz, mx ) );
    var tx = Dot( mx, this.pos );
    var ty = Dot( my, this.pos );
    var tz = Dot( [-mz[0], -mz[1], -mz[2]], this.pos ); 
    var m = IdentityMat44();
    m[0]  = mx[0]; m[1]  = my[0]; m[2]  = mz[0]; m[3]  = 0;
    m[4]  = mx[1]; m[5]  = my[1]; m[6]  = mz[1]; m[7]  = 0;
    m[8]  = mx[2]; m[9]  = my[2]; m[10] = mz[2]; m[11] = 0;
    m[12] = tx;    m[13] = ty;    m[14] = tz;    m[15] = 1; 
    return m;
} 

// shader program object
var ShaderProgram = {};
ShaderProgram.Create = function( shaderList, uniformNames ) {
    var shaderObjs = [];
    for ( var i_sh = 0; i_sh < shaderList.length; ++ i_sh ) {
        var shderObj = this.CompileShader( shaderList[i_sh].source, shaderList[i_sh].stage );
        if ( shderObj == 0 )
            return 0;
        shaderObjs.push( shderObj );
    }
    var progObj = this.LinkProgram( shaderObjs )
    if ( progObj != 0 ) {
        progObj.unifomLocation = {};
        for ( var i_n = 0; i_n < uniformNames.length; ++ i_n ) {
            var name = uniformNames[i_n];
            progObj.unifomLocation[name] = gl.getUniformLocation( progObj, name );
        }
    }
    return progObj;
}
ShaderProgram.Use = function( progObj ) { gl.useProgram( progObj ); } 
ShaderProgram.SetUniformInt = function( progObj, name, val ) { gl.uniform1i( progObj.unifomLocation[name], val ); }
ShaderProgram.SetUniformFloat = function( progObj, name, val ) { gl.uniform1f( progObj.unifomLocation[name], val ); }
ShaderProgram.SetUniform2f = function( progObj, name, arr ) { gl.uniform2fv( progObj.unifomLocation[name], arr ); }
ShaderProgram.SetUniform3f = function( progObj, name, arr ) { gl.uniform3fv( progObj.unifomLocation[name], arr ); }
ShaderProgram.SetUniformMat44 = function( progObj, name, mat ) { gl.uniformMatrix4fv( progObj.unifomLocation[name], false, mat ); }
ShaderProgram.CompileShader = function( source, shaderStage ) {
    var shaderScript = document.getElementById(source);
    if (shaderScript) {
      source = "";
      var node = shaderScript.firstChild;
      while (node) {
        if (node.nodeType == 3) source += node.textContent;
        node = node.nextSibling;
      }
    }
    var shaderObj = gl.createShader( shaderStage );
    gl.shaderSource( shaderObj, source );
    gl.compileShader( shaderObj );
    var status = gl.getShaderParameter( shaderObj, gl.COMPILE_STATUS );
    if ( !status ) alert(gl.getShaderInfoLog(shaderObj));
    return status ? shaderObj : 0;
} 
ShaderProgram.LinkProgram = function( shaderObjs ) {
    var prog = gl.createProgram();
    for ( var i_sh = 0; i_sh < shaderObjs.length; ++ i_sh )
        gl.attachShader( prog, shaderObjs[i_sh] );
    gl.linkProgram( prog );
    status = gl.getProgramParameter( prog, gl.LINK_STATUS );
    if ( !status ) alert("Could not initialise shaders");
    gl.useProgram( null );
    return status ? prog : 0;
}
        
function drawScene(){
    var canvas = document.getElementById( "model-canvas" );
    Camera.create();
    Camera.vp = [canvas.width, canvas.height];
    var currentTime = Date.now();   
    var deltaMS = currentTime - startTime;
        
    gl.viewport( 0, 0, canvas.width, canvas.height );
    gl.enable( gl.DEPTH_TEST );
    gl.clearColor( 0.0, 0.0, 0.0, 1.0 );
    gl.clear( gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT );

    var texUnit = 0;
    gl.activeTexture( gl.TEXTURE0 + texUnit );
    gl.bindTexture( gl.TEXTURE_2D, textureObj );
    
    // set up draw shader
    ShaderProgram.Use( progDraw );
    ShaderProgram.SetUniformMat44( progDraw, "u_projectionMat44", Camera.Perspective() );
    ShaderProgram.SetUniformMat44( progDraw, "u_viewMat44", Camera.LookAt() );
    ShaderProgram.SetUniform3f( progDraw, "u_lightDir", [-1.0, -0.5, -2.0] )
    ShaderProgram.SetUniform3f( progDraw, "u_color", [1.0, 0.5, 0.0] )
    var modelMat = IdentityMat44()
    modelMat = RotateAxis( modelMat, CalcAng( currentTime, 13.0 ), 0 );
    modelMat = RotateAxis( modelMat, CalcAng( currentTime, 17.0 ), 1 );
    ShaderProgram.SetUniformMat44( progDraw, "u_modelMat44", modelMat );
    ShaderProgram.SetUniformInt( progDraw, "u_texture", texUnit );
    
    // draw scene
    bufObj = bufSphere;
    gl.enableVertexAttribArray( progDraw.inPos );
    gl.enableVertexAttribArray( progDraw.inNV );
    gl.enableVertexAttribArray( progDraw.inTex );
    gl.bindBuffer( gl.ARRAY_BUFFER, bufObj.pos );
    gl.vertexAttribPointer( progDraw.inPos, 3, gl.FLOAT, false, 0, 0 );
    gl.bindBuffer( gl.ARRAY_BUFFER, bufObj.nv );
    gl.vertexAttribPointer( progDraw.inNV, 3, gl.FLOAT, false, 0, 0 );
    gl.bindBuffer( gl.ARRAY_BUFFER, bufObj.tex );
    gl.vertexAttribPointer( progDraw.inTex, 2, gl.FLOAT, false, 0, 0 );
    gl.bindBuffer( gl.ELEMENT_ARRAY_BUFFER, bufObj.inx );
    gl.drawElements( gl.TRIANGLES, bufObj.inxLen, gl.UNSIGNED_SHORT, 0 );
    gl.disableVertexAttribArray( progDraw.inPos );
    gl.disableVertexAttribArray( progDraw.inNV );
    gl.disableVertexAttribArray( progDraw.intex );
}

var startTime;
function Fract( val ) { 
    return val - Math.trunc( val );
}
function CalcAng( currentTime, varervall ) {
    return Fract( (currentTime - startTime) / (1000*varervall) ) * 2.0 * Math.PI;
}

var sphere_pts = [];
var sphere_nv = [];
var sphere_tex = [];
var sphere_inx = [];
function AddVertex( x, y, z, nvX, nvY, nvZ, u, v )
{
     sphere_pts.push( x, y, z );
     sphere_nv.push( nvX, nvY, nvZ );
     sphere_tex.push( u, v ); 
}
function AddFace( i1, i2, i3, i4 )  {
    sphere_inx.push( i1, i2, i3 );
    if ( i4 )
        sphere_inx.push( i1, i3, i4 );
}

var gl;
var progDraw;
var bufSphere = {};
var textureObj;
function sceneStart() {
    var canvas = document.getElementById( "model-canvas");
    var vp = [canvas.width, canvas.height];
    gl = canvas.getContext( "experimental-webgl" );
    if ( !gl )
      return;

    progDraw = ShaderProgram.Create( 
      [ { source : "draw-shader-vs", stage : gl.VERTEX_SHADER },
        { source : "draw-shader-fs", stage : gl.FRAGMENT_SHADER }
      ],
      [ "u_projectionMat44", "u_viewMat44", "u_modelMat44", "u_lightDir", "u_texture" ] );
    progDraw.inPos = gl.getAttribLocation( progDraw, "inPos" );
    progDraw.inNV = gl.getAttribLocation( progDraw, "inNV" );
    progDraw.inTex = gl.getAttribLocation( progDraw, "inTex" );
    if ( progDraw == 0 )
        return;

    // create sphere vertices
    var layer_size = 16, circum_size = 32, radius = 1.0;
    var circCnt = circum_size;
    var circCnt_2 = circCnt / 2;
    var layerCount = layer_size;
    for ( var tbInx = 0; tbInx <= layerCount; tbInx ++ )
    {
        var v = ( 1.0 - tbInx / layerCount );
        var heightFac = Math.sin( ( 1.0 - 2.0 * tbInx / layerCount ) * Math.PI/2.0 );
        var cosUp = Math.sqrt( 1.0 - heightFac * heightFac );
        var z = heightFac;
        for ( var i = 0; i <= circCnt_2; i ++ )
        {
          var u = i / circCnt_2;
          var angle = Math.PI * u;
          var x = Math.cos( angle ) * cosUp;
          var y = Math.sin( angle ) * cosUp;
          AddVertex( x * radius, y * radius, z * radius, x, y, z, u, v );
        }
        for ( var i = 0; i <= circCnt_2; i ++ )
        {
          var u = i / circCnt_2;
          var angle = Math.PI * u + Math.PI;
          var x = Math.cos( angle ) * cosUp;
          var y = Math.sin( angle ) * cosUp;
          AddVertex( x * radius, y * radius, z * radius, x, y, z, u, v );
        }
    }
    
    // bottom cap
    var circSize_2 = circCnt_2 + 1;
    var circSize = circSize_2 * 2;
    for ( var i = 0; i < circCnt_2; i ++ )
        AddFace( circSize + i, circSize + i + 1, i );
    for ( var i = circCnt_2+1; i < 2*circCnt_2+1; i ++ )
        AddFace( circSize + i, circSize + i + 1, i );

    // discs
    for ( var tbInx = 1; tbInx < layerCount - 1; tbInx ++ )
    {
        var ringStart = tbInx * circSize;
        var nextRingStart = (tbInx+1) * circSize;
        for ( var i = 0; i < circCnt_2; i ++ )
            AddFace( ringStart + i, nextRingStart + i, nextRingStart + i + 1, ringStart + i + 1 );
        ringStart += circSize_2;
        nextRingStart += circSize_2;
        for ( var i = 0; i < circCnt_2; i ++ )
            AddFace( ringStart + i, nextRingStart + i, nextRingStart + i + 1, ringStart + i + 1 );
    }

    // top cap
    var start = (layerCount-1) * circSize;
    for ( var i = 0; i < circCnt_2; i ++ )
        AddFace( start + i + 1, start + i, start + i + circSize );
    for ( var i = circCnt_2+1; i < 2*circCnt_2+1; i ++ )
        AddFace( start + i + 1, start + i, start + i + circSize );
    
    bufSphere.pos = gl.createBuffer();
    gl.bindBuffer( gl.ARRAY_BUFFER, bufSphere.pos );
    gl.bufferData( gl.ARRAY_BUFFER, new Float32Array( sphere_pts ), gl.STATIC_DRAW );
    bufSphere.nv = gl.createBuffer();
    gl.bindBuffer( gl.ARRAY_BUFFER, bufSphere.nv );
    gl.bufferData( gl.ARRAY_BUFFER, new Float32Array( sphere_nv ), gl.STATIC_DRAW );
    bufSphere.tex = gl.createBuffer();
    gl.bindBuffer( gl.ARRAY_BUFFER, bufSphere.tex );
    gl.bufferData( gl.ARRAY_BUFFER, new Float32Array( sphere_tex ), gl.STATIC_DRAW );
    bufSphere.inx = gl.createBuffer();
    gl.bindBuffer( gl.ELEMENT_ARRAY_BUFFER, bufSphere.inx );
    gl.bufferData( gl.ELEMENT_ARRAY_BUFFER, new Uint16Array( sphere_inx ), gl.STATIC_DRAW );
    bufSphere.inxLen = sphere_inx.length;

    var texCX = 128;
    var texCY = 128;
    var texPlan = [];
    for (ix = 0; ix < texCX; ++ix) {
        for (iy = 0; iy < texCY; ++iy) {
            var val_x = Math.sin( Math.PI * 12.0 * ix / texCX )
            var val_y = Math.sin( Math.PI * 12.0 * iy / texCY )
            var r = val_x < -0.33 ? 0 : ( val_x < 0.33 ? 127 : 255 );
            var g = val_x < -0.33 ? 255 : ( val_x < 0.33 ? 127 : 0 );
            var b = val_y < -0.33 ? 0 : ( val_y < 0.33 ? 127 : 255 );
            texPlan.push( r, g, b, 255 );
        }
    }
    textureObj = gl.createTexture();
    gl.activeTexture( gl.TEXTURE0 );
    gl.bindTexture( gl.TEXTURE_2D, textureObj );
    gl.texImage2D( gl.TEXTURE_2D, 0, gl.RGBA, texCX, texCY, 0, gl.RGBA, gl.UNSIGNED_BYTE, new Uint8Array( texPlan ) );
    gl.pixelStorei( gl.UNPACK_FLIP_Y_WEBGL, true );
    gl.texParameteri( gl.TEXTURE_2D, gl.TEXTURE_MAG_FILTER, gl.LINEAR );
    gl.texParameteri( gl.TEXTURE_2D, gl.TEXTURE_MIN_FILTER, gl.LINEAR );
    gl.texParameteri( gl.TEXTURE_2D, gl.TEXTURE_WRAP_S, gl.REPEAT );
    gl.texParameteri( gl.TEXTURE_2D, gl.TEXTURE_WRAP_T, gl.REPEAT );

    startTime = Date.now();
    setInterval(drawScene, 50);
}