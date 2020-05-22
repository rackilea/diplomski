public static Classifier init(String modelPath) {
    long cPtr = CLJNI.Classifier_init__SWIG_0(modelPath);
    return (cPtr == 0) ? null : new Classifier(cPtr, true);
  }

  public static Classifier init(byte[] modelMemory) {
    long cPtr = CLJNI.Classifier_init__SWIG_1(modelMemory);
    return (cPtr == 0) ? null : new Classifier(cPtr, true);
  }