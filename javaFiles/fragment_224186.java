// create a ProgressDialog instance, with a specified theme:    
ProgressDialog dialog = new ProgressDialog(mContext, ProgressDialog.THEME_HOLO_DARK);
// set indeterminate style
dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
// set title and message
dialog.setTitle("Please wait");
dialog.setMessage("Loading dictionary file...");
// and show it
dialog.show();