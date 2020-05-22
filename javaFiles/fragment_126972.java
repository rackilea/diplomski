%extend {
    context() {
      // Constructor that gets called when this object is created from Java:
      struct context *ret = NULL;
      init_context(&ret); 
      return ret;
    }
    ~context() {
      release_context($self);
    }
    void foo() {
      foo($self);
    }
  }