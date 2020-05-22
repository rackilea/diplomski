public View buildView(View v, LayoutInflater inflater, ViewGroup parent,Context context,int position) {
   ViewHolder viewHolder;
   if (v == null) {
      v = inflater.inflate(layoutId, parent, false);
      viewHolder = new ViewHolder();
      invokeView(viewHolder, v);
      v.setTag(viewHolder);
   } else {
       viewHolder = v.getTag();
   }
   //...
}

protected void invokeView(ViewHolder viewHolder, View v) {
    try {
         Field fs[] = viewHolder.getClass().getFields();
         for (Field f : fs) {
             InvokeView a = (InvokeView) f.getAnnotation(InvokeView.class);
             int id = a.viewId();
             f.set(viewHolder, v.findViewById(id));

         }
     } catch (Exception ex) {
         ex.printStackTrace();
     }
 }