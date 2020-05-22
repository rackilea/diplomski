class A {
   int x;
public:
   A() : X(0) {}
   virtual void f() { x=x+1; }
   virtual int getX() { return x; }
};

int main() {
   A *a = (A *)malloc(sizeof(A));
   cout << a->getX();
   free(a);
}