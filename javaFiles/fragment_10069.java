class Bar {
public:
  virtual void foo() final;
};

class Error : public Bar {
public:
  virtual void foo() final;
};