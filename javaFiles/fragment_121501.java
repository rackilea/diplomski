public static double azimuth(double lat, double declination, double zenith, double hourAngle)
{
  double elevation = Math.toRadians(90 - zenith);
  lat = Math.toRadians(lat);
  declination = Math.toRadians(declination);
  hourAngle = Math.toRadians(hourAngle);
  double azimuthRadian = acos(((sin(declination) * cos(lat)) - (cos(hourAngle) * cos(declination) * sin(lat))) / cos(elevation));
  double azimuthDegree = Math.toDegrees(azimuthRadian);
  if (hourAngle > 0)
    azimuthDegree = 360 - azimuthDegree;
  System.out.println("Azimuth: " + df.format(azimuthDegree));
  return azimuthDegree;
}