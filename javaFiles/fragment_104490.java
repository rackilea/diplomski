try {
  Object3D[] roots = Loader.load( "http://www.example.com/scene.m3g" );

  World world = roots[0];
  Mesh mesh = world.find( MESH_ID );
}
catch( Exception e ) {
  // Handle it
}