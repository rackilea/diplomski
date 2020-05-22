for(GeneralTreeNode child : children) {
   GeneralTreeNode result = child.findNode(targetName);
   if (result != null) {
        return result;
   }

}