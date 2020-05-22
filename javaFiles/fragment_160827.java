// If the drop items are files
 if (flavor.isFlavorJavaFileListType()) {

     // Get all of the dropped files
     List files = (List) transferable.getTransferData(flavor);

         // Loop them through
         for (File file : files) {