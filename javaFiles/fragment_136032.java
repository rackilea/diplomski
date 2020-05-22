public interface A {
       int getValue(); 
    }

    public interface MutableA extends A {
       void setValue( int i );
    }