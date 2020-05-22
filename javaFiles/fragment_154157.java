public static boolean isVisited(int x, int y){
  for(int i = 0; i < visitedX.size(), i++){
    if(visitedX.get(i) == x){
      if(visitedY.get(i) == y){
        return true;
      }
    }
   }
  return false;
}