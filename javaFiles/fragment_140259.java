for (int k = 0; k < dataPoints.size(); k++) {
  if (dataPoints.get(k) != xMin) {
    return false;
  }
}
return true;