public float interpolate(Point currentPoint, List<Point> neighbors) {
  int dimensions = neighbors.size();
  float[] distance = new float[dimensions];
  float sumDistances = 0;
  for (int i = 0; i < dimensions; i++) {
    distance[i] = currentPoint.distance(neighbors.get(i));
    sumDistances += distance[i];
  }
  float[] weight = new float[dimensions];
  for (int i = 0; i < dimensions; i++) {
    weight[i] = 1 - distance[i] / sumDistances;
  }
  float interpolatedDistance = 0;
  for (int i = 0; i < dimensions; i++) {
    interpolatedDistance += neighbors.get(i).getValue() * weight[i];
  }
  return interpolatedDistance;
}