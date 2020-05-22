protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
int id = getIntent().getExtras().getInt("id");
setContentView(R.layout.profilo);
       ///NEW
  LoginDataBase dbLogin =  new LoginDataBase (this, "NAMEOFDATABASE", null, 1);
      ///END OF NEW
    SQLiteDatabase db = dbLogin.getWritableDatabase();

}

}