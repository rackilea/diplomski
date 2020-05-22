@Module
public class ModuleA {
    @Singleton
    @Provides
    public A a(B b) {
        return new A(b);
    }

    @Singleton
    @Provides
    public B b(C c) {
        return new B(c);
    } 

    @Singleton
    @Provides
    public C c() {
        return new C();
    } 
}