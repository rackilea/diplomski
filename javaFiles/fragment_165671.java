String aName = A.class.getSimpleName();
EClassifier classif = FooPackage.eInstance.getEClassifier(aName);
if (classif != null && classif instanceof EClass) {
  // At this point, you have the right EClass, 
  // you can now create an instance using the factory
  EObject myinstance = FooFactory.eInstance.create((EClass)classif);
}