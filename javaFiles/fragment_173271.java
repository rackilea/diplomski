public View getView(int position, View convertView, ViewGroup parent){
      // create new imageTapView
      JSONObject thisPost = posts.getJSONObject(position);
      if(convertView==null)
            convertView = new ImageTapView(context, thisPost);
      else{
      ((ImageTapView)convertView).setPost(thisPost); 
      }
     return convertView;
 }