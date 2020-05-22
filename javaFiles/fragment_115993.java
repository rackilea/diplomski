@Component(value="treeView")
@Scope(value = "session")
public class TreeView implements Serializable {

    private TreeNode[] selectedClassifiers;

    public TreeNode[] getSelectedClassifiers() {
        return selectedClassifiers;
    }

    public void setSelectedClassifiers(TreeNode[] selectedClassifiers) {
        this.selectedClassifiers = selectedClassifiers;
    }

    private TreeNode selectedClassifier;

    public void reset(){
        selectedClassifier = null;
    }

    public void displaySelectedSingle(){
        if(selectedClassifier != null){
             List<TreeNode> selected = new ArrayList<TreeNode>();
             for(int i=0; i < selectedClassifiers.length; i++){
                 selected.add(selectedClassifiers[i]);
                 if(selectedClassifiers[i].equals(selectedClassifier))
                     selected.addAll(selectionRecursive(selectedClassifier));
             }
             selectedClassifiers = selected.toArray(new TreeNode[selected.size()]);
        }

    }

    public void onContextMenu(NodeSelectEvent event){
     selectedClassifier = event.getTreeNode();
    }

    public List<TreeNode> selectionRecursive(TreeNode node){

        List<TreeNode> selected = node.getChildren();

        for(TreeNode child : node.getChildren()){
            selected.addAll(selectionRecursive(child));
            child.setSelected(true);
        }

        return selected;
    }
}