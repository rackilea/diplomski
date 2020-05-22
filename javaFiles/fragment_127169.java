Map params = new HashMap();
String url = "http://host.com/routingRequest?returnJSON=true&timeout=60000&to=s%3A73746647+d%3Afalse+f%3A-1.0+x%3A-74.454383+y%3A40.843021+r%3A-1.0+cd%3A-1.0+fn%3A-1+tn%3A-1+bd%3Atrue+st%3ACampus%7EDr&returnGeometries=true&nPaths=1&returnClientIds=true&returnInstructions=true
&hour=12+00&from=s%3A-1+d%3Afalse+f%3A-1.0+x%3A-74.241765+y%3A40.830182+r%3A-1.0+cd%3A-1.0+fn%3A56481485+tn%3A26459042+bd%3Afalse+st%3AClaremont%7EAve&sameResultType=true&type=HISTORIC_TIME";
List<NameValuePair> params = URLEncodedUtils.parse(new URI(url), "UTF-8");

for (NameValuePair param : params) {
  map.put(param.getName(),param.getValue());
}