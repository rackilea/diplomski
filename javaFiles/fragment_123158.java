int dup = 0;
int abs = 0;
for( int i = 0; i < a.length; ++i ){
    if( a[i] <= 0 ) continue;
    int val = a[i];
    a[i] = 0;
    while( true ){
        if( a[val-1] == -val ){
            dup = val;
            break;
        } else {
            int h = a[val-1];
            a[val-1] = -val;
            if( h == 0 ) break;
            val = h;
        }
    }
}
for( int i = 0; i < a.length; ++i ){
    if( a[i] >= 0 ){
         abs = i+1;
         break;
    }
}