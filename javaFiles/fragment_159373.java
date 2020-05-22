Iterator<SomeResource> it = this.someResource().iterator();
List<String> list = StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, Spliterator.ORDERED), false)
                                 .filter(resource -> !resource.isTaken())
                                 .limit(MAX_TO_RELEASE)
                                 .peek(SomeResource::release)
                                 .map(SomeResource::getName)
                                 .collect(Collectors.toList());
return new ReleaseResult(list, it.hasNext(), MAX_TO_RELEASE);