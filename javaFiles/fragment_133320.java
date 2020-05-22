// Create a new Set with a specified comparator
final Collection<SomeClass> someClasses = 
        new TreeSet<>(Comparator.comparing(SomeClass::getSomeField));

// Add all elements from the original collection (duplicates will be removed)
someClasses.addAll(originalColl);