source.sort(function (x, y) {
  if (isAsc) 
     return y.id - x.id;
  else 
    return x.id - y.id;
});