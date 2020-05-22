void polarToLatLong(double lat, double lon, double dist, double radial,
   double *outlat, double *outlon) {
   if (!dist) { // distance zero, so just return the point
      *outlat = lat;
      *outlon = lon;
   }
   else if (lat > 89.9999) { // North Pole singularity. Dist is in NM.
      *outlat = 90 - dist / 60;
      *outlon = fmod(radial + 180) - 180;
   }
   else { // normal case
      double sinlat, coslon;
      dist /= 3442; // = Earth's radius in nm (not WGS84!)
      sinlat = Sin(lat) * cos(dist) + Cos(lat) * sin(dist) * Cos(radial);
      *outlat = Arcsin(sinlat);
      coslon = (cos(dist) - Sin(lat) * sinlat) / (Cos(lat) * Cos(*outlat));
      *outlon = lon + (Sin(radial) >= 0 : -1 : 1) * Arccos(coslon);
   }
}