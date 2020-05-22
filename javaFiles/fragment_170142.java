protected void onPostExecute(String file_url) 
        {
         friendsadapter=new LazyAdapterInventory(this, friendsList);  
         friendslist.setAdapter(friendsadapter);
         friendsadapter.notifyDataSetChanged();
         }
 }