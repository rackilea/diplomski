%typemap(javabody) A %{
      private long swigCPtr;
      protected boolean swigCMemOwn;

      protected $javaclassname(long cPtr, boolean cMemoryOwn) {
      super(cPtr,cMemoryOwn);
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
      }
     %}