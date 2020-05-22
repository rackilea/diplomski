map(i,x,y) {
  for j in 1:N/k #k is size of submatrix
     emit((i/k, j), ("row", (x,y)))
     emit((j, i/k), ("col", (x,y)))

reduce ((a,b), Z)
  split Z in rows X and cols Y
  for x in X
     for y in Y
     emit(dist(x,y))