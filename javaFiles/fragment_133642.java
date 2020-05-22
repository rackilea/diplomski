public void onCreate(Bundle savedInstanceState)
{
   super.onCreate(savedInstanceState);

   Bundle b = getIntent().getExtras();
   int intValue;

   if (b != null)
   {
      intValue= b.getInt("intName");
   }
}