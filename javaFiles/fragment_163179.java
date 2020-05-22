package com.example.route;

public class A {

    private B b;

    public A(B b) {
        this.b = b;
    }

    public B getB() {
        return b;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("A{");
        sb.append("b=").append(b);
        sb.append('}');
        return sb.toString();
    }
}