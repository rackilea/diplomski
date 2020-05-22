..
Result getResult1() {
    viewScopeCache.get(new ViewScopeCacheCommand<Result>() { 
      ..invoke(){ call anything X }}); // does not need to be SQL, can be a service A call
}
..
Result getResult2() {
    viewScopeCache.get(new ViewScopeCacheCommand<Result>() { 
     ..invoke(){ call anything Y}}); // does not need to be SQL, can be a service B call
 }
..