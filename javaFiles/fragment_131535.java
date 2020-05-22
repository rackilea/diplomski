/** Create variable */
private Dialog dialog;
private LoadAsyn loadAsync;

/** Call the AsyncTask */
dialog = ProgressDialog.show(getActivity(), "", "Caricamento...", false, true);
dialog.setCancelable(false);
loadAsync = new LoadAsyn();
loadAsync.execute((Void) null);