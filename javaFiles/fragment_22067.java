public class UnionFind
{
  private int[] id;

  public UnionFind(int capacity)
  {
    id = new int[capacity];
    for (int i = 0; i < capacity; i++)
    {
      id[i] = i;
    }
  }

  public boolean isConnected(int p, int q)
  {
    return root(p) == root(q);
  }

  public void connect(int p, int q)
  {
    if (isConnected(p, q))
    {
      return;
    }

    id[root(p)] = root(q);
  }

  private int root(int p)
  {
    int temp = p;

    if (p != id[p] && id[id[p]] != id[p])
    {
      while (p != id[p])
      {
        p = id[p];
      }

      id[temp] = id[p];
    }

    return id[p];
  }
}