class EffectivelyImmutable {
    static EffectivelyImmutable unsafe;
    private int i;
    public EffectivelyImmutable (int i) { this.i = i; }
    public int get() { return i; }
}

// in some thread
EffectivelyImmutable.unsafe = new EffectivelyImmutable(1);

//in some other thread
if (EffectivelyImmutable.unsafe != null
    && EffectivelyImmutable.unsafe.get() != 1)
    System.out.println("What???");