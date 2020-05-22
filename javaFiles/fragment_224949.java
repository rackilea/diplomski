public interface IDoSomething {
    public int Return42();
    public bool AmIPrettyOrNot(string name);
    public void Foo();
} 

public void Main(String[] args) {
    DoStuff(new IDoSomething() {
        public int Return42() { return 42; }
        public bool AmIPrettyOrNot(string name) { return name == "jerkimball"; }
        public bool Foo(int x) { ... }
    });
}

public void DoStuff(IDoSomething something) { ... }