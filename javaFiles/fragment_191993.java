Location instanceLoc = Platform.getInstanceLocation();
// TODO check for null

if (!instanceLoc.isSet()) {
  URL url = .... work out a location for the workpace 

  instanceLoc.set(url, false);
}