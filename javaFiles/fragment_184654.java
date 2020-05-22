ArrayList<String> ntarray= new ArrayList<String>();    
    ArrayList<Drawable> ndarray= new ArrayList<Drawable>();

    if(position==0){
      for(int i=0;i<wcount;i++){
          ntarray.set(i, titlearray[i+1]);
          ndarray.set(i, imageId[i+1]);
      }
    }

   if(position==wcount-1){
      for(int i=0;i<wcount-1;i++){
         ntarray.set(i, titlearray[i]);
         ndarray.set(i, imageId[i]);
      }
   }

   adapter = new CustomGrid(Wishlist.this, ntarray, ndarray);
   grid.setAdapter(adapter);
   adapter.notifyDataSetChanged();
   dialog.hide();