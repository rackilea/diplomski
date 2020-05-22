button_Delete_File.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) { //Remove item from list and delete assigned file.
       if (Build.VERSION.SDK_INT >= 19) {
           try {
               Uri uri = Uri.parse(reports.get(getAdapterPosition()).getPath());
               ContentResolver contentResolver = context.getContentResolver();
               contentResolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
               DocumentsContract.deleteDocument(contentResolver, uri);
               reports.remove(getAdapterPosition());
               notifyItemRemoved(getAdapterPosition());
           } catch (FileNotFoundException e) {
               Toast.makeText(context, context.getResources().getString(R.string.delete_file_not_found), Toast.LENGTH_SHORT).show();
           }
       } else {
           File file = new File(reports.get(getAdapterPosition()).getPath());
           file.delete();
           if (!file.exists()) {
               reports.remove(getAdapterPosition());
               notifyItemRemoved(getAdapterPosition());
           } else {
               Toast.makeText(context, context.getResources().getString(R.string.delete_file_error), Toast.LENGTH_SHORT).show();
           }
       }
   }
});