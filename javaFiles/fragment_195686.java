public void add(int n)
{   
    arraySet[totalNum]=n;
    totalNum++;
    makeSet();
}

public void makeSet()
{
  for(int i=0;i<totalNum;i++)
      set.add(arraySet[i]);
}