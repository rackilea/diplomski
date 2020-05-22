if(value.compareTo((T) Tree.getValue()) < 0){

            th = nodeExist(Tree.getLeft(), value);

        }else{

            th = nodeExist(Tree.getRight(), value);
        }