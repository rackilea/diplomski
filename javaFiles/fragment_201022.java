private static MainActivity _instance = null; 

     @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            encode = new Encode();

            enableReaderMode();

           MainActivity._instance = this;
        }

        public static MainActivity getInstance() {
            return _instance;
        }