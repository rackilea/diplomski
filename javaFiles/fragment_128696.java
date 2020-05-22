DfaState<Integer> st = startState;
for (... each input character c ...)
{
    st = st.getNextState(c);
    //if this is non-null, then it's the index of the matched keyword
    //in the keywords list
    Integer match = st.getMatch();
}