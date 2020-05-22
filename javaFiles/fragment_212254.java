int max = Math.Max(ar1.Count, ar2.Count);
ArrayList ar3 = new ArrayList();

for (int i=0; i < max; i++)
{
    if (i < ar1.Count)
    {
       ar3.Add(ar1[i]);
    }
    if (i < ar2.Count)
    {
       ar3.Add(ar2[i]);
    }
}