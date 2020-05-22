for ( int i = 0; i < ROW_COUNT; i++ ) {
    for ( int j = 0; j < COL_COUNT; j++ ) { 
       Integer val = matrix.get(new Point(i, j));
       //val is null here if not stored in the matrix.  Replace with a different
       //default as desired.  eg:
       //if ( val == null ) val = 0;
       process(val);
    }
}