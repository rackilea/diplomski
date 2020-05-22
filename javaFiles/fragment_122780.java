public enum A implements MassProvider {
    MASS(10);
    private int mass;

    A(int mass) {
        this.mass = mass;
    }

    @Override
    public int getMass() {
        return mass;
    }
}

public enum B implements MassProvider {
    MASS(100);
    private int mass;

    B(int mass) {
        this.mass = mass;
    }

    @Override
    public int getMass() {
        return mass;
    }
}

public interface MassProvider {
    int getMass();
}

public static int mass(MassProvider p) {
    return p.getMass();
}