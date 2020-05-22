List<String> getRecordsDetail(Object records)
{
  if (records instanceof Vector)
  {
    Object blam;
    Iterator iterator;
    Vector recordVector = (Vector)records;

    iterator = recordVector.iterator();
    while (iterator.hasNext())
    {
      blam = iterator.next();
      // do something with blam.
    }
  }
}