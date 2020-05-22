try {
 // Pulling items from the array
 TreeNode root = TreeNode.root();
 TreeNode child;
 String year = "YEAR";
 String moduleName = "";
 YearHolder.IconTreeItem nodeItem = new YearHolder.IconTreeItem(1, year);
 ModuleHolder.IconTreeItem nodeModule = new ModuleHolder.IconTreeItem(1, moduleName);
 TreeNode parent = new TreeNode(nodeItem).setViewHolder(new YearHolder(_mainContext));
 TreeNode parentModule = new TreeNode(nodeModule).setViewHolder(new ModuleHolder(_mainContext));
 JSONArray modArr = jsonObject.getJSONArray("notes");
 try {
  for (int i = 0; i < modArr.length(); i++) {
   JSONObject tmp = modArr.getJSONObject(i);
   /*String title = tmp.getString("title");*/
   String final_note = tmp.getString("final_note");
   String newModuleName = tmp.getString("titlemodule");
   String newYear = tmp.getString("scolaryear");
   if (!(newYear.equals(year))) {
    year = newYear;
    nodeItem = new YearHolder.IconTreeItem(1, year);
    parent = new TreeNode(nodeItem).setViewHolder(new YearHolder(_mainContext));
    root.addChild(parent);
   }
   if (!(newModuleName.equals(moduleName))) {
    moduleName = newModuleName;
    nodeModule = new ModuleHolder.IconTreeItem(1, moduleName);
    parentModule = new TreeNode(nodeModule).setViewHolder(new ModuleHolder(_mainContext));
    parent.addChild(parentModule);
   }
   NoteHolder.IconTreeItem nodeNote = new NoteHolder.IconTreeItem(1, final_note);
   child = new TreeNode(nodeNote).setViewHolder(new NoteHolder(_mainContext));
   parentModule.addChildren(child);

   /*String display = year + " | " + title + " | " + final_note;*/
  }
  AndroidTreeView tView = new AndroidTreeView(_notesActivity, root);
  _notesActivity.setContentView(tView.getView());
 } catch (JSONException e) {
  e.printStackTrace();
  Toast.makeText(_mainContext, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
 }

} catch (JSONException e) {
 e.printStackTrace();
 Toast.makeText(_mainContext, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
}