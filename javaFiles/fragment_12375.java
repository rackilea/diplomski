static <E> void permK(List<E> p, int i, int k)
{
  if(i == k)
  {
    System.out.println(p.subList(0, k));
    return;
  }

  for(int j=i; j<p.size(); j++)
  {
    Collections.swap(p, i, j);
    permK(p, i+1, k);    
    Collections.swap(p, i, j);
  }
}