public void generateNodes(Category categories,DefaultMutableTreeNode root){
        ArrayList<Use> usages = categ.getUsages();
        for(Use use: usages){
            categ.getNode().add(use.getNode());
        }
        if(!categ.getCategories().isEmpty()){
            root.add(categ.getNode());

            for(Category cat: categ.getCategories(){
                generateNodes(categ, root);
            }

        }else{
            root.add(categ.getNode());
        }

}