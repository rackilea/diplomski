public class Register implements Cloneable {

private boolean[] register;

public Register(boolean[] register) {

    int n = register.length;

    if (n == 8 || n == 16 || n == 32 || n == 64) {
        this.register = register;
    } else {

        throw new IllegalArgumentException(
                "A register can only contain 8, 16, 32, or 64 bits");
    }

}

@Override
public String toString() {

    StringBuilder builder = new StringBuilder();

    for ( boolean b : this.register ) {
        builder.append( b ? "1" : "0" );
    }

    return builder.toString();
}

public Register( int n ) {
    this( new boolean[n] );
}

public int getLength() {
    return this.register.length;
}

@Override
public Register clone() {

    boolean[] clonedRegister = new boolean[this.register.length];

    System.arraycopy(this.register, 0, clonedRegister,0, this.register.length);

    return new Register( clonedRegister );
}

}