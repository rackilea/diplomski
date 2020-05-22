@NotifyChange("treeModel")
@Command
public void select(@BindingParam("treeNode") final Tree tree){
    if(tree.getIsCheckable()){
        if(tree.getIsChecked() == true){
            tree.setIsChecked(false);
        }else{
            tree.setIsChecked(true);
        }
    }

}