SubTypeOfSomething subTyped = …

// from specific values
Stream<Something> s1 = Stream.of(subTyped);

// from existing collection
Set<SubTypeOfSomething> set = Collections.singleton(subTyped);
// note: this creates the stream directly from the source set
Stream<Something> s2 = Collections.<Something>unmodifiableSet(set).stream();

// if you really unavoidably have a more specifically typed Stream
Stream<SubTypeOfSomething> s3 = set.stream();
Stream<Something> s4 = s3.map(Function.identity());