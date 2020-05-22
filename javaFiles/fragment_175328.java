private void permute(List<List<Boolean>> list, int t)
{
    for(int i = 0; i < list.size(); i ++)
    {
        Collections.swap(list.get(i), 0, 1);
        permute(list, t + 1);
        Collections.swap(list.get(i), 1, 0);
    }

    if(t == list.size() - 1)
        System.out.println("Another permutation.");
}