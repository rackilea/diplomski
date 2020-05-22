private void doSomethingA(EnumSet<TypeA>){ ... }

private void doSomethingA(EnumSet<TypeA>){ ... }

private void <T extends Enum<T>> doSomething(EnumSet<T extends BaseType> s, T tInst){
    if(t instanceof TypeA) doSomethingA(s);
    if(t instanceof TypeB) doSomethingB(s);
}