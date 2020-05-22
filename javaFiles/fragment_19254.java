Table table = new Table();
XMLTable xtable = new XMLTable();

File[] files = null; 
File projectsDirectory = new File("projects");
files = projectsDirectory.listFiles();
for( File f : files){
    if(f.isDirectory()){
        TreeNode treeNode = new DefaultMutableTreeNode(f.getName());
        root.add(treeNode);// parent node added
        for(File fc : f.listFiles()){

            if(fc.isFile() && fc.getName().equalsIgnoreCase("table.xml")){

                table = xtable.getXMLTable("table.xml");
                ArrayList<Column> cols = table.getColumns();
                for(Column col:cols){
                    treeNode.add(new DefaultMutableTreeNode(col.getName()));
                }
            }
        }
    }
}