protected void onPostExecute(String file_url) {
   super.onPostExecute(file_url); 
    pDialog.dismiss();
    ListAdapter adapter = new SimpleAdapter(
                       getActivity(), subjectList,
                    R.layout.all_subject, new String[] { TAG_MATRIX_ID,
                            TAG_NAME},
                    new int[] { R.id.matrix_id, R.id.name });
    myListView.setAdapter(adapter);
   }