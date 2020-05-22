interface Section {
   void someMethod();
   void accept(SectionVisitor visitor);
}

interface MapSection extends Section {
   void additionalProcessingMethod();
}