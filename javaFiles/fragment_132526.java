Iterator outerLoop = coll.iterator(); 
while (outerLoop.hasNext) { 
    Iterator innerLoop = coll.iterator(); 
    while (innerLoop.hasNext()){ 
        innerLoop.remove(); //ConcurrentModificationException
     }
 }