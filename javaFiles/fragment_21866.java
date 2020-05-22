for(int i = 0; i < currentSize; i++)
{
  if((customerName.get(i)).equals("Meg"))
  {
    customerName.remove(i);
    i--;  //because a new element may be at i now
    currentSize = customerName.size(); //size has changed
  }
}