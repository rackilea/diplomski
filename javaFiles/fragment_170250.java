boolean includePropertyDefintions = true;
      for (t in session.getTypeDescendants(
            null, // start at the top of the tree
            -1, // infinite depth recursion
            includePropertyDefintions // include prop defs
            )) {
         printTypes(t, "");
      }

   static void printTypes(Tree tree, String tab) {          
      ObjectType objType = tree.getItem();
      println(tab + "TYPE:" + objType.getDisplayName() +
            " (" + objType.getDescription() + ")");
      // Print some of the common attributes for this type
      print(tab + " Id:" + objType.getId());                            
      print(" Fileable:" + objType.isFileable());
      print(" Queryable:" + objType.isQueryable());

      if (objType instanceof DocumentType) {                            
         print(" [DOC Attrs->] Versionable:" +
            ((DocumentType)objType).isVersionable());
         print(" Content:" +
            ((DocumentType)objType).getContentStreamAllowed());
      }
      println(""); // end the line
      for (t in tree.getChildren()) {
         // there are more - call self for next level
         printTypes(t, tab + " ");
      }
   }