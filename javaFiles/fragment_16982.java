for ( int x = 0;  x < row;  x++ ) {
    for(int y = 0; y < col; y++) {
        if((x + y)%2 == 0) {
            BoxColor = Color.red;
        } else {
            BoxColor = Color.black;
        }

        ...

    }
}