List<? extends SequenceContainer> scs = ...;
SpecialSequenceContainer exampleSSC = ...; /// SpecialSequenceContainer extends 
SortedMap<Integer, String> option1 = noNameFunction(scs, exampleSSC, ssc -> ssc.t2OwnMethod());
// or 
SortedMap<Integer, String> option2 = noNameFunction(scs, exampleSSC, 
    SpecialSequenceContainer::t2OwnMethod);