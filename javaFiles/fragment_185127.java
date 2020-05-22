public enum ABCD {
    A {
        @Override
        public <RESULT> RESULT accept(Visitor<RESULT> visitor) {
            return visitor.visitA(this);
        }
    },
    B {
        @Override
        public <RESULT> RESULT accept(Visitor<RESULT> visitor) {
            return visitor.visitB(this);
        }
    },
    C {
        @Override
        public <RESULT> RESULT accept(Visitor<RESULT> visitor) {
            return visitor.visitC(this);
        }
    },
    D {
        @Override
        public <RESULT> RESULT accept(Visitor<RESULT> visitor) {
            return visitor.visitD(this);
        }
    };

    public abstract <RESULT> RESULT accept(Visitor<RESULT> visitor);
}