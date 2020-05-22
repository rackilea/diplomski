for ( int tbInx = 1; tbInx < layerCount - 1; tbInx ++ )
{
  int ringStart = tbInx * circSize;
  int nextRingStart = (tbInx+1) * circSize;
  for ( int i = 0; i < circCnt_2; i ++ )
    AddFace( ringStart + i, nextRingStart + i, nextRingStart + i + 1, ringStart + i + 1 );
  ringStart += circSize_2;
  nextRingStart += circSize_2;
  for ( int i = 0; i < circCnt_2; i ++ )
    AddFace( ringStart + i, nextRingStart + i, nextRingStart + i + 1, ringStart + i + 1 );
}