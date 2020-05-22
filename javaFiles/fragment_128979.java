void max_heapify(int a[],int i,int n) {
    int mxPos = i;
    int l = i*2; // left child
    int r = i*2+1; // right child

    if( l <= n and a[l] > a[mxPos] ) mxPos = l;
    if( r <= n and a[r] > a[mxPos] ) mxPos = r;

    if( mxPos != i ) {
        swap( a[i] , a[mxPos] );
        max_heapify( a , mxPos , n );
    }
}

void build_max_heap( int a[] ,int n) {
    for(int i = n / 2 ; i >= 1 ; i-- ) max_heapify(a,i,n);
}

void heapsort(int a[],int n) {
    build_max_heap(a,n);
    for( int i = n ; i >= 2 ; i-- ) {
        swap( a[1] , a[i] );
        n--;
        max_heapify( a , 1 , n );
    }
}

int main() {
    int n , a [100] ;
    cin >> n ;
    for( int i = 1 ; i <= n ; i++ ) cin >> a[i] ;
    heapsort(a,n);
    for( int i = 1 ; i <= n ; i++ ) cout << a[i] << endl;
}