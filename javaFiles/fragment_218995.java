public static boolean allDifferentAtLevel(BinaryTree a, int lev){
    return checker(new HashSet<Integer>(),a,0,lev); //EmptySet, Root, CurrentLevel, Level
}

public static boolean checker(HashSet<Integer> set,BinaryTree a, int currentLevel, int lev) {
    if(a==null) //If current node of tree is null, return true.
        return true;

    if(currentLevel==lev) //If currentLevel is the required level, We don't need to move further.
                          //We can just validate the data at currentLevel and return the appropriate value.
    {
        int value=a.val();
        if(set.contains(value)) //If set contains the value, Duplication found.
            return false;

        set.add(value);
        return true;
    }

    //Check for both of the children.
    return checker(set,a.left(),currentLevel+1,lev) && checker(set,a.right(),currentLevel+1,lev);
}