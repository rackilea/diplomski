public static DocumentFile documentfile(final File file ) {   
  for (UriPermission permissionUri : con.getContentResolver().getPersistedUriPermissions()) {   
        DocumentFile rootDocFile = DocumentFile.fromTreeUri(con, permissionUri.getUri());    
        String[] parts = (file.getPath()).split("/");    
          for (int i = 3; i < parts.length; i++) {        
            if (rootDocFile != null) {
                rootDocFile = rootDocFile.findFile(parts[i]);
            }
            if (rootDocFile != null) {
                break;
            }
            //else {
            //    rootDocFile = DocumentFile.fromTreeUri(con, permissionUri.getUri());
            //    rootDocFile = rootDocFile.findFile(parts[i]);
            //}        
          }
      }
      return rootDocFile;
}