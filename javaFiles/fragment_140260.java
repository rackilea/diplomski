for (int k = 0; k < dataPoints.size(); k++) {
  if (dataPoints.get(k) == xMin) {   // != has been changed to ==
    return true;                     // Return true as soon as we've found it
  }
}
return false;                        // Return false if it wasn't found