static public Shape getOutsideEdge(Graphics gc, Rectangle bb, int top, int lft, int btm, int rgt) {
    int                                 ot=bb.y            , it=(ot+top);
    int                                 ol=bb.x            , il=(ol+lft);
    int                                 ob=(bb.y+bb.height), ib=(ob-btm);
    int                                 or=(bb.x+bb.width ), ir=(or-rgt);

    return new Polygon(
     new int[]{ ol, ol, or, or, ol, ol,   il, ir, ir, il, il },
     new int[]{ it, ot, ot, ob, ob, it,   it, it, ib, ib, it },
     11
     );
    }