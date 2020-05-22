transitionInput = data.nextLine();
st = new StringTokenizer(transitionInput,"()", false);
if (st.hasMoreTokens())
{
    String chunk = st.nextToken();
    st = new StringTokenizer(chunk, ",");
    while (st.hasMoreTokens())
    {
        transition.add(st.nextToken());
    }
}