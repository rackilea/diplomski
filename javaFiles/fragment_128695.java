//The <Integer> here means you want integer results
DfaBuilder<Integer> builder = new DfaBuilder<>();

//Lets say you have a list of keywords:
for (int i=0; i<keywords.size(); ++i)
{
    Pattern pat = Pattern.maybeRepeat(CharRange.ALL)
        .then(keywords.get(i));
    builder.addPattern(pat, i);  //when this pattern matches, we get i out
}
DfaState<Integer> startState = builder.build(null);