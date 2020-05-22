public static void populateArray(int[]level,Node root,int currentLevel) {
    currentLevel++; // Increase currentLevel by 1 first
    if(root.left!=null) {
        populateArray(level,root.left,currentLevel);
    }
    level[currentLevel]++; // Increase level by 1 after that
    if(root.right!=null) {
        populateArray(level,root.right,currentLevel);
    }
}

public static void populateArray2(int[]level,Node root,int currentLevel) {
    if(root.left!=null) {
        currentLevel++;
        populateArray2(level,root.left,currentLevel);
    }
    level[currentLevel]++; // Increase level by 1 first
    if(root.right!=null) {
        currentLevel++; // Increase currentLevel by 1 after that
        populateArray2(level,root.right,currentLevel);
    }
}