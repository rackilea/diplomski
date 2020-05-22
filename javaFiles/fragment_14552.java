@Override
protected void onPostExecute(Void result) {
    String valueofelement = elem.text();
    story.add(valueofelement);        //story is an array
    progressDialog.dismiss();
   }
}