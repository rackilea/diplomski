interface A { void methodA(); }
interface B { void methodB(); }
interface C extends A, B {}

class First implements A { ... }
class Second implements C { ... }