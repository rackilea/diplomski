int circCnt = (int)( circumferenceTile + 0.5f );
if ( circCnt < 4 ) circCnt = 4;
int circCnt_2 = circCnt / 2;
int layerCount = (int)( layerTile + 0.5f );
if ( layerCount < 2 ) layerCount = 2;

for ( int tbInx = 0; tbInx <= layerCount; tbInx ++ )
{
  float v = ( 1.0 - (float)tbInx / layerCount );
  float heightFac = Math.sin( ( 1.0 - 2.0 * tbInx / layerCount ) * Math.PI/2.0 );
  float cosUp = Math.sqrt( 1.0 - heightFac * heightFac );
  float z = heightFac;
  for ( int i = 0; i <= circCnt_2; i ++ )
  {
    float u = (float)i / (float)circCnt_2;
    float angle = Math.PI * u;
    float x = Math.cos( angle ) * cosUp;
    float y = Math.sin( angle ) * cosUp;
    AddVertex( x * radius, y * radius, z * radius, x, y, z, u, v );
  }
  for ( int i = 0; i <= circCnt_2; i ++ )
  {
    float u = (float)i / (float)circCnt_2;
    float angle = Math.PI * u + Math.PI;
    float x = Math.cos( angle ) * cosUp;
    float y = Math.sin( angle ) * cosUp;
    AddVertex( x * radius, y * radius, z * radius, x, y, z, u, v );
  }
}