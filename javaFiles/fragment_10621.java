Iterator<?> it = ...; // get the iterator somehow; often by calling iterator() on a Collection
while (it.hasNext())
{
   Object obj = it.next();
   // Do something with the obj
}