// Change the extending class type
public class AlbumsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

// Add this 
public class TextViewHolder extends RecyclerView.ViewHolder {
      public TextView textView;
      public TextViewHolder(View itemView) {
         super(itemView);
         textView = (TextView) itemView.findViewById(R.id.text3);
      }
   }

// Add this
@Override
public int getItemViewType(int position) {
   if ( albumList.get(position).getName().length() == 0)
      return 1;
   return 0;
}

@Override
   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View itemView = null;
      switch ( viewType ) {
         case 0:
            itemView = LayoutInflater.from(parent.getContext())
                  .inflate(R.layout.album_card, parent, false);
            return new MyViewHolder(itemView);
         case 1:
            itemView = LayoutInflater.from(parent.getContext())
                  .inflate(R.layout.text_layout, parent, false);
            return new TextViewHolder(itemView);
      }

      return null;
   }

   @Override
   public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
      Album album = albumList.get(position);
      if ( album.getName().length() == 0) {
         TextViewHolder text = (TextViewHolder)holder;
         text.textView.setText("New Text");
      } else {
         final MyViewHolder myHolder = (MyViewHolder)holder;
         myHolder.title.setText(album.getName());
         myHolder.count.setText(album.getNumOfSongs() + " songs");

         // loading album cover using Glide library
         Glide.with(mContext).load(album.getThumbnail()).into(myHolder.thumbnail);

         myHolder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showPopupMenu(myHolder.overflow);
            }
         });
      }
   }
}