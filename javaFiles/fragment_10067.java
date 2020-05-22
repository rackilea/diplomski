class Bar {
public:
   virtual void foo() const {
   }
};

class Error: public Bar {
public:
   // Fine in C++
   virtual void foo() const {
   }
};