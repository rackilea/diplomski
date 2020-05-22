public static PhysicsVector[] copyArray(PhysicsVector[] a) {
    int length = a.length;
    PhysicsVector[] copy = new PhysicsVector[length];
    System.arraycopy(a, 0, copy, 0, length);
    return copy;
}