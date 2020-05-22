protected void onPostExecute(ArrayList<HashMap<String,String>> result) {

              super.onPostExecute(result);
              // your code here...
               mainArrayList=chunkList(result,10);
               isLoadingMore=false;
               count=0;
               adapter = new CustomAdapterSent(Interestsent.this, 
                                            mainArrayList.get(count));
               setListAdapter(adapter);
        }

    }