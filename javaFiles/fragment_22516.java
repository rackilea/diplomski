void effect(int filterationSize) {
    image.loadPixels(); 

    int tiles_x = width / filterationSize;
    if ( width % filterationSize > 0 ) 
        tiles_x += 1;
    int tiles_y = height / filterationSize;
    if ( height % filterationSize > 0 ) 
        tiles_y += 1;

    print( tiles_x, tiles_y );
    for ( int tile_y = 0; tile_y < tiles_x; tile_y ++ ) {
        for ( int tile_x = 0; tile_x < tiles_y; tile_x ++ ) {

            int start_x = tile_x*filterationSize;
            int start_y = tile_y*filterationSize;
            int end_x   = min(start_x+filterationSize, width); 
            int end_y   = min(start_y+filterationSize, height);
            int size    = (end_x-start_x) * (end_y-start_y);

            float r = 0, g = 0, b = 0;
            for (int by = start_y; by < end_y; by++ ) {
                for (int bx = start_x; bx < end_x; bx++ ) {
                    int p = by * width + bx;
                    r += red(this.image.pixels[p])   / size;
                    g += green(this.image.pixels[p]) / size;
                    b += blue(this.image.pixels[p])  / size;
                }
            }

            for (int by = start_y; by < end_y; by++ ) {
                for (int bx = start_x; bx < end_x; bx++ ) {
                    int p = by * width + bx;
                    this.image.pixels[p] = color(r, g, b);
                }
            }
        }
    }
    this.image.updatePixels();
}