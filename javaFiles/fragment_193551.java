public QueryBase(Context context) { 
    super(context, DATABASE_NAME, null, DATABASE_VERSION);  

    this.sqh = this;
    this.sqdb = sqh.getWritableDatabase();
}