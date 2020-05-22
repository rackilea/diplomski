private volatile Map<String, String> cacheData;

if(cacheData == null) {
  cacheData = unmodifiableMap(getDataFromDatabase());
}
return cacheData;