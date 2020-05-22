class X
    class Y
        static int z;

X x1 = new X();
X.Y y1 = x1.new Y();    

X x2 = new X();
X.Y y2 = x2.new Y();    
X.Y y3 = x2.new Y();