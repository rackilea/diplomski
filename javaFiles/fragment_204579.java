String whichSet = externalWebService.whichSetShouldIUse();
if(whichSet.equals("HashSet"))
  foo = new HashSet()<>;
else if(whichSet.equals("TreeSet"))
  foo = new TreeSet()<>;

// At this point, how would the compiler know what 'foo' actually is?