JTree.DropLocation dropLocation = tree.getDropLocation();
 if (dropLocation != null
         && dropLocation.getChildIndex() == -1
         && tree.getRowForPath(dropLocation.getPath()) == row) {

     // this row represents the current drop location
     // so render it specially, perhaps with a different color
 }