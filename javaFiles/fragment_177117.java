AddVertex( x, y, z, nvX, nvY, nvZ, u, v );
AddFace( i1, i2, i3 );
AddFace( i1, i2, i3, i4 ) {AddFace( i1, i2, i3 ); AddFace( i1, i3, i4 ); }

int circumferenceTile = 18;
int layerTile = 18;
float radius = 1.0;