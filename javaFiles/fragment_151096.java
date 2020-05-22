adap.setViewBinder(new SimpleCursorAdapter.ViewBinder() {
    @Override
    public boolean setViewValue(View view, Cursor cursor, int i) {
        if (view.getId() == R.id.iv_photo) {
            byte[] data = cursor.getBlob(i);

            Bitmap  bitmap = null;
            // TODO: decode blob data - should be done off UI thread.

            ((ImageView) view).setImageBitmap(bitmap);
            // Return true to signal that the value was bound to a view 
            // successfully.
            return true;
        } else {
            // Return false for all other views and let the default  
            // binder deal with them.
            return false;
        }
    }
});