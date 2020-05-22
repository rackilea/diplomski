abstract class P {

    int p1;
    int p2;

    abstract void visit(final PVisitor visitor);
}

class P1 extends P {

    int p3;
    int p4;

    @Override
    void visit(PVisitor visitor) {
        visitor.doStuff(this);
    }
}

class P2 extends P {

    int p5;
    int p6;

    @Override
    void visit(PVisitor visitor) {
        visitor.doStuff(this);
    }
}

interface PVisitor {

    void doStuff(P1 p);

    void doStuff(P2 p);
}