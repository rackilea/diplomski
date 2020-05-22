public void insert(String path, Context context)
{
     info = new adapter(context);
     filename = path; 

     try
     {
         startActivity(new Intent(context,hello.class));
     }
     catch(Exception e)
     {
         Log.v("Caught in insert() of FileEvent : ",e.toString());
     } 
}