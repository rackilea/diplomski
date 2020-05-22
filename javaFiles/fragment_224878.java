private Context mContext; //Help I'm null
        Cursor cursor;
        history historyClass = new history();
        MySQLiteHelper db; 

        public HistoryAdapter(Context context, Cursor cur){
            super();
            mContext = context;
            cursor = cur;
            db = new MySQLiteHelper(context); //not null anymore
        }