int let1= (int)letter1;
int let2= (int)letter2;
if(userChoice.length()<=2){
    // cant find BinaryTree ERROR
    TreeNode commonAncestor= findLowestCommonAncestor(root,
                        BinaryTree.get(let1), BinaryTree.get(let2));
                                       ^^^^                  ^^^^