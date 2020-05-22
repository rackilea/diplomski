void draw(float x, float y, float width, float height, Color color) {


    if (idx==verts.length)
        flush();

    //assuming (0, 0) is lower left, and Y is up

    //bottom left vertex
    verts[idx++] = x;           //Position(x, y) 
    verts[idx++] = y;
    verts[idx++] = color.r;             //Color(r, g, b, a)
    verts[idx++] = color.g;
    verts[idx++] = color.b;
    verts[idx++] = color.a;

    //top left vertex
    verts[idx++] = x;           //Position(x, y) 
    verts[idx++] = y + height;
    verts[idx++] = color.r;             //Color(r, g, b, a)
    verts[idx++] = color.g;
    verts[idx++] = color.b;
    verts[idx++] = color.a;

    //bottom right vertex
    verts[idx++] = x + (width / 2);         //Position(x, y) 
    verts[idx++] = y + (height / 2);
    verts[idx++] = color.r;             //Color(r, g, b, a)
    verts[idx++] = color.g;
    verts[idx++] = color.b;
    verts[idx++] = color.a;
            //2
            //|\
            //| \ 3
            //| /
            //|/
            //1

    //
    verts[idx++] = x + width;       //Position(x, y) 
    verts[idx++] = y + height;
    verts[idx++] = color.r;             //Color(r, g, b, a)
    verts[idx++] = color.g;
    verts[idx++] = color.b;
    verts[idx++] = color.a;

    //
    verts[idx++] = x;           //Position(x, y) 
    verts[idx++] = y + height;
    verts[idx++] = color.r;             //Color(r, g, b, a)
    verts[idx++] = color.g;
    verts[idx++] = color.b;
    verts[idx++] = color.a;

    //
    verts[idx++] = x + (width / 2);         //Position(x, y) 
    verts[idx++] = y + (height / 2);
    verts[idx++] = color.r;             //Color(r, g, b, a)
    verts[idx++] = color.g;
    verts[idx++] = color.b;
    verts[idx++] = color.a;

            //2_____1
            // \   /
            //  \ /
            //   3
            //
            //

            //
    verts[idx++] = x + width;       //Position(x, y) 
    verts[idx++] = y;
    verts[idx++] = color.r;             //Color(r, g, b, a)
    verts[idx++] = color.g;
    verts[idx++] = color.b;
    verts[idx++] = color.a;

    //
    verts[idx++] = x + width;       //Position(x, y) 
    verts[idx++] = y + height;
    verts[idx++] = color.r;             //Color(r, g, b, a)
    verts[idx++] = color.g;
    verts[idx++] = color.b;
    verts[idx++] = color.a;

    //
    verts[idx++] = x + (width / 2);         //Position(x, y) 
    verts[idx++] = y + (height / 2);
    verts[idx++] = color.r;             //Color(r, g, b, a)
    verts[idx++] = color.g;
    verts[idx++] = color.b;
    verts[idx++] = color.a;

            //      2
            //     /|
            //   3/ |
            //    \ |
            //     \|
            //      1

    //
    verts[idx++] = x;                   //Position(x, y) 
    verts[idx++] = y;
    verts[idx++] = color.r;             //Color(r, g, b, a)
    verts[idx++] = color.g;
    verts[idx++] = color.b;
    verts[idx++] = color.a;

    //
    verts[idx++] = x + width;       //Position(x, y) 
    verts[idx++] = y;
    verts[idx++] = color.r;             //Color(r, g, b, a)
    verts[idx++] = color.g;
    verts[idx++] = color.b;
    verts[idx++] = color.a;

    //
    verts[idx++] = x + (width / 2);         //Position(x, y) 
    verts[idx++] = y + (height / 2);
    verts[idx++] = color.r;             //Color(r, g, b, a)
    verts[idx++] = color.g;
    verts[idx++] = color.b;
    verts[idx++] = color.a;

            //   3
            //  /\
            // /__\
            // 1  2 
    flush();
}