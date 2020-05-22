public int getTotalWeight(){
    int w = 0;
    for(int i =0; i< size; i++){
        w = fishArray[i].getWeight() + w;
    }
    return w;
  }

  public Fish getLargest(){
    int heaviest = Integer.MIN_VALUE;
    for(int i = 0; i < size; i++){
        if (fishArray[i].getWeight() > heaviest) {
           heaviest = fishArray[i].getWeight();
           index = i;
        }            
    }
    return fishArray[index];
  }

  public Fish getSmallest(){
    int small = Integer.MAX_VALUE;
    for(int i = 0; i < size; i++){
        if (fishArray[i].getWeight() < small) {
           small = fishArray[i].getWeight();
           index=i;
        }            
    }
    return fishArray[index];
  }