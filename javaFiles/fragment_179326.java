private int calcDepth( Tree<K, V> x, K keyIn, int currentLevel){ 

  if(x == null) return -1; // key doesnt exist if this is true

  if (x.key.compareTo(keyIn) == 0) return currentLevel;  //BASE CASE  

  if (x.key.compareTo(keyIn) < 0){   // check left tree
      return calcDepth(x.left, keyIn, currentLevel+1);  
  }

  if (x.key.compareTo(keyIn) > 0){  // check right tree
      return calcDepth(x.right, keyIn, currentLevel + 1); 
  }

  return -1; 
}