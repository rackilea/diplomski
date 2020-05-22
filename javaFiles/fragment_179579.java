public static void main(String[] args){
//        countTrees(3, false);
        System.out.println(countTrees(3, false));
        //System.out.println(count);
    }
    public static int countTrees(int numKeys, boolean internal) {
        //int temp = 0;
          int count = 0;
          if (numKeys <=1) {
              count += 1;
            return(1); 
          } 
          else { 
            int sum = 0; 

            int left, right, root;

            for (root=1; root<=numKeys; root++) {
              left = countTrees(root-1, true); 
              right = countTrees(numKeys - root, true);

              // number of possible trees with this root == left*right 
              sum += left*right; 
              count += root*left*right;

            }
//            System.out.println(count);
            if( internal )return(sum);
            else return count;
          }
    }