public void accept(SomeVisitor visitor) {

        visitor.accept(this);

        visitor.accept(new InnerA() {
            @Override 
            public void setX(int theX) {
                x = theX;
            }
            @Override 
            public int getX() {
                return x;
            }
            // Same for y....
        });
    }