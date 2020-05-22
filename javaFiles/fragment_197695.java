/**
 * Calculate the distance in KM
 * 
 * @param l2
 * @return
 */
public double afstandTot(Locatie l2) {
  double lon1 = longitude / 180 * Math.PI;
  double lon2 = l2.longitude / 180 * Math.PI;
  double lat1 = latitude / 180 * Math.PI;
  double lat2 = l2.latitude / 180 * Math.PI;
  double x1 = Math.cos(lon1) * Math.cos(lat1);
  double y1 = Math.sin(lon1) * Math.cos(lat1);
  double z1 = Math.sin(lat1);

  double x2 = Math.cos(lon2) * Math.cos(lat2);
  double y2 = Math.sin(lon2) * Math.cos(lat2);
  double z2 = Math.sin(lat2);

  double psi = Math.acos(x1 * x2 + y1 * y2 + z1 * z2);
  double afstand = DOORSNEDE_AARDE / (2 * Math.PI) * psi;
  return afstand;