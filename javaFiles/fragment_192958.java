Example strongReferenceWrappedInWeak = new Example(42);
strongReferenceWrappedInWeak.printA();

WeakReference<Example> exampleWeakReference = new WeakReference<>(strongReferenceWrappedInWeak);

System.gc();

Example retrievedExample = exampleWeakReference.get();
retrievedExample.printA(); //this works, because a strong reference is present to the instance, hence it's not cleared

retrievedExample = null;
strongReferenceWrappedInWeak = null; //now eligible for garbage collection

System.gc();

Example retrievedExampleTwo = exampleWeakReference.get(); //will be null
retrievedExampleTwo.printA(); //will throw NPE