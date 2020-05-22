List<Integer> list = new ArrayList<Integer>();
for(int i = 0; i < 40;)
{
    int rand = ((int)(Math.random() * 40)) + 1;
    if(!list.contains(rand))
    {
        list.add(rand);
        i++;
    }
}