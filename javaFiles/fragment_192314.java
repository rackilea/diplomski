String strfromMobileno="";
 public adapter(Context context, int layout, Cursor c,
                    String[] from, int[] to,String fromMobileno) {
     super(context, layout, c, from, to);
     ///... your code here 
     strfromMobileno=fromMobileno;
  }