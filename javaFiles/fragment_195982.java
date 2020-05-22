interface A {
    void foo();
}

interface B {
    void bar();
}

class Agent {
    private Optional<A> delegateA = Optional.empty();
    private Optional<B> delegateB = Optional.empty();

    public void addA(A delegate) {
        delegateA = Optional.of(delegate);
    }

    public boolean implementsA() {
        return delegateA.isPresent();
    }

    public void foo() {
        delegateA.ifPresent(A::foo);
    }
}

Agent agent = new Agent();
agent.addA(() -> System.out.println("foo"));
agent.implementsA();
agent.foo();