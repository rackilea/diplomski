Connection c = requests.getIfPresent(request);
if (c != null) {
  requests.invalidate(request); // remove from the waiting area
  // proceeed with processing the request
} else {
  // the request was evicted from the cache as it expired
}