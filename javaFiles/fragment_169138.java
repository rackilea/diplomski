protected void onPreExecute() {
        dialog = new ProgressDialog(context);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.show();
 }

 protected void onPostExecute(Map<Integer, String> integerStringMap) {
        if (dialog!=null)
            dialog.cancel();
 }

 protected void onProgressUpdate(Integer... values) {
        int val = values[0]*10000/num;
        dialog.setProgress(val);
 }