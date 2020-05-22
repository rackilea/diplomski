public void FS(){
             findSmallest(root, 0);
         }
         private int findSmallest(BSTNode r, int val){
             if(r == null) return val;
             if(r == root)val = r.repeatCount;

             if(r.repeatCount < val){
                 val = r.repeatCount;
                 smallestCount = r;
             }

             val = findSmallest(r.left,val);    
             val = findSmallest(r.right,val);

             return val;

     }