Object o;
if (listObject instanceof RandomAccess)
{
  for (int i=0, n=list.size(); i < n; i++)
  {
    o = list.get(i); // directly get the object as list implements Random access
    //do something with object o
  }

}
else
{
  Iterator itr = list.iterator();
  for (int i=0, n=list.size(); i < n; i++)
  {
    o = itr.next(); // Use iterator to get values sequentially as random access 
                    //  is not fast for this list and hence does not implement RandomAccess
    //do something with object o

  }
}