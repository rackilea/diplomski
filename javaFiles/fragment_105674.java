@Entity
class Base { ... }

@EntitySubclass(index=true)
class A extends Base { ... }

@EntitySubclass(index=true)
class B extends Base { ... }