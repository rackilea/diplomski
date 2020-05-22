private Context mContext; //Help I'm null
        Cursor cursor;
        history historyClass = new history();
        MySQLiteHelper db = new MySQLiteHelper(mContext); //null is inserted here

        public HistoryAdapter(Context context, Cursor cur){
            super();
            mContext = context;
            cursor = cur;
        }