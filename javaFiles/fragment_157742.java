public ArrayList<Object> MoversAndShakers = new ArrayList<>();

ArrayList<Object>  getMovingObjects(ArrayList<Object> World)
{
  ArrayList<Object> MoversAndShakers = new ArrayList<>();

  for(Object currentObj : World)
  {
     if (currentObj.velocity > 0)
          MoversAndShakers.add(currentObj);
  }
  return MoversAndShakers;
}