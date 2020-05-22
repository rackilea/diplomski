Student strongReference = new Student(); 

SoftReference<Student> softReference = new SoftReference<>(strongReference);
 strongReference = null; // object in heap is softly reachable now
 Student anotherStrongReference = softReference.get();
 if(anotherStrongReference != null){
      // you have a strong reference again
 }