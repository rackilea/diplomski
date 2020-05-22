Your adapter...    

private static final int ItemTypeButton = 0;
private static final int ItemTypeImage = 1;

@override
public int getViewTypeCount()
{
   return 2; // 2 because you want two type of view. (One button and the rest is images)
}

@override
public int getItemViewType(int position)
{
 /* it's better to use item view type
    to determine what type of view 
    you want to display. This is used
    for recycling views for optimization. */
  return position == 0 ? ItemTypeButton : ItemTypeImage; 
}

public View getView(final int position, View convertView, ViewGroup parent) {
   int type = getItemViewType(position);

   /* Check whether convertView intance is null. If null, then inflate.
      Otherwise the view is recycled for optimization. */
   if (convertView == null)
   {
      if (type == ItemTypeButton)
      {
         // inflate button view
      }
      else if (type == ItemTypeImage)
      {
         // inflate your view for image
      }
   }

   // This is where you should update your view states.
   if (type == ItemTypeImage)
   {
     /* ... */
     holder.imageView = (ImageView) view.findViewById(R.id.imageView1);
     holder.imageView.setImage(.....
   }
   else
   {
     /* ... */
   }
}