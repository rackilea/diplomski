.flatMap(i -> { 
  try { 
    int result = 6 / i; 
    return Observable.just(result); 
  } catch (Exception e) { 
    return Observable.empty(); 
  } 
})