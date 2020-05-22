interface E {
    A getA();
    B getB();
}

interface A {}

interface B extends Comparable<B> {}