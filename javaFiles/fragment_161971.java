public Cars getNextCar(Cars e)
{
  int index = e.ordinal();
  int nextIndex = index + 1;
  Cars[] cars = Cars.values();
  nextIndex %= cars.length;
  return cars[nextIndex];
}