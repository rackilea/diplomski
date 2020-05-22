Example strongReferenceWrappedInWeak = new Example(42);
strongReferenceWrappedInWeak.printA();

WeakReference<Example> exampleWeakReference = new WeakReference<>(strongReferenceWrappedInWeak);

System.gc(); //does not collect object, since strong reference still exists

exampleWeakReference.get().printA(); //works

strongReferenceWrappedInWeak = null; //eligible for garbage collection
System.gc(); //collects object, since it is now weakly referenced only

exampleWeakReference.get().printA(); //throws NPE