struct A1 { };
struct A2 { };

struct B1 {
    virtual void f(A1*) = 0;
};

struct B2 {
    virtual void f(A2*) = 0;
};

struct D : B1, B2 { };

void f(D& d)
{
    A1 a1;
    A2 a2;
    d.f(&a1);
    d.f(&a2);
}