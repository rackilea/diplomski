map(x,y) {
  for i in 1:N #number of points
     emit(i, (x,y))

reduce (i, X)
  p1 = X[i]
  for j in i:N
     emit(dist(X[i], X[j]))