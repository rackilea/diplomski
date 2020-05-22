// this to recreate the cache in memory once the user refresh, it will keep the data if exisit but will point to it again in memory 
if (CacheFactory.get('profileCache') == undefined) {
  //if there is no cache already then create new one and assign it to profileCache
  CacheFactory.createCache('profileCache');
}

function getCurrentSession() {
  var profileCache = CacheFactory.get('profileCache');
  if (profileCache !== undefined && profileCache.get('Token') !== undefined) {
    return profileCache.get('Token');
  }
  return null;
}

function getToken() {
  var currentSession = getCurrentSession();
  if (currentSession != null && currentSession != '') {
    return currentSession.token;
  }
  return null;
}