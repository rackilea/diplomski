Sort both arrays 
indexSmall=0 

// sum up
for all elements e in bigArray {
  // increase index as long as we get "closer"
  while (dist(e,smallArray(indexSmall)) > dist(e,smallArray(indexSmall+1)) {
    indexSmall++
  }
  sum += f(dist(e,smallArray(indexSmall)));
}