public QueryBase(Context context) { 
    super(context, DATABASE_NAME, null, DATABASE_VERSION);  

    this.sqh = new QueryBase(context);
    this.sqdb = sqh.getWritableDatabase();
}