struct type1 {
  type1(int foo) : foo(foo) {}
  int foo;
};

struct type2 {
  type2(double bar) : bar(bar) {}
  double bar;
};

// TYPE3 is int32_t, TYPE4 is const char*

typedef enum { TYPE1, TYPE2, TYPE3, TYPE4 } type_t;

void* fetch(type_t type) {
  switch(type) {
  case TYPE1:
    return new type1(101);
  case TYPE2:
    return new type2(1.111);
  case TYPE3:
    return (void*)(-123); // One way of returning int32_t via void*!
  case TYPE4:
    return (void*)("Hello world"); // Cast because not const void*
  default:
    return NULL;
  }
}