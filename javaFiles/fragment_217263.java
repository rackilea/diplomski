Iterator<Date> it = dates_ordered.iterator (); // create an iterator object
while (it.hasNext ())
{
  Date d = it.next ();
  Integer i = my_hashmap.get (d); // access value in hashmap with this key

  // do something with "i" here
  // ...
}