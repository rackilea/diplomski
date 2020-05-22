static List<Integer> extractRepeats(List<Integer> in)
{
    List<Integer> result = new ArrayList<>();
    for(int i=1, j=0; i<=in.size(); i++)
    {
        if((i == in.size() || in.get(i) != in.get(i-1)) && ++j < i)
        {
            for(j--; j<i; j++) 
            {
                result.add(in.get(j));
            }
        }
    }
    return result;
}