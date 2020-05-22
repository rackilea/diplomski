private static boolean cancelled = false;

fillInTreeView(File x, TreeItem root) {
   if(cancelled) return;
   if (x.isFile()) {
        newBranch = makeBranch(x.getName(x.getNameCount() - 1).toString(), root);
        assignMark(newBranch);
    } else {
        newBranch = makeBranch(x.getName(x.getNameCount() - 1).toString(), root);
        assignMark(newBranch);
        fillInTreeView(x, newBranch);
    }
}

/*Your CLick-Listener*/
public void onClick(){
       cancelled = true;
}