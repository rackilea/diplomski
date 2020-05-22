while (enemyIterator.hasNext()){

     Sprite nextEnemy=enemyIterator.next(); //I get the error here.. -> push stact trace

      if(enemySpr.getY()+enemySpr.getHeight()>=treeObj.treeSpr.getY()){

           enemyIterator.remove();
           //removeEnemy(nextEnemy);
       }
 }