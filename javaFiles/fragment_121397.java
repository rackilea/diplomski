/**
      * Find all classes that access methods or fields in this class
      * from within the same project.
      * @param element the Java element the search pattern is based on
      * @param scope the elements being examined, e.g. this class or this package
      * @return the handles of the classes that have methods that
      *  reference methods or fields in this class
      */
     public static Set<String> calculateCallingClasses(IJavaElement element,
                     IJavaSearchScope scope)
                     throws CoreException {
             SearchEngine engine = new SearchEngine();
             SearchParticipant[] participants =
                     new SearchParticipant[] { SearchEngine.getDefaultSearchParticipant() };
             SearchPattern pattern =
                     SearchPattern.createPattern(element, REFERENCES);
             IType enclosingType =
                     (IType)element.getAncestor(IJavaElement.TYPE);
             ClientClassCollector collector = new ClientClassCollector(enclosingType);
             try{
                     engine.search(pattern, participants, scope, collector, null);
             } catch (Exception e) {
                     System.err.println(e.toString() + " for " + element.getElementName());
             } 
            Set<String> clients = collector.getResult();
            return clients;
     }