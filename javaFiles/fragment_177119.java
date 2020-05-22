int circSize_2 = circCnt_2 + 1;
int circSize = circSize_2 * 2;
for ( int i = 0; i < circCnt_2; i ++  )
  AddFace( circSize + i, circSize + i + 1, i );
for ( int i = circCnt_2+1; i < 2*circCnt_2+1; i ++ )
  AddFace( circSize + i, circSize + i + 1, i );