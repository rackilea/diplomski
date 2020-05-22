@ManagedBean
@ViewScoped
public class TreeMBean {

    private TreeNode rootNode;

     @PostConstruct
     public void init() {
         TheTree root = new TheTree(); // instead get root object from database 
         rootNode = newNodeWithChildren(root, null);
     }

     /**
      *  recursive function that returns a new node with its children
     */
     public TreeNode newNodeWithChildren(TheTree ttParent, TreeNode parent){
          TreeNode newNode= new DefaultTreeNode(ttParent, parent);
          for (TheTree tt : ttParent.getChildren()){
               TreeNode newNode2= newNodeWithChildren(tt, newNode);
          }
          return newNode;
     }

     public TreeNode getRootNode() {
         return rootNode;
     }

     public void setRootNode(TreeNode node) {
         rootNode = node;
     }

 }