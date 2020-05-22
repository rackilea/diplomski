public static Singleton getInstance(Activity context){

        mContext = context;
        if(mInstance == null)
        {
            synchronized (Singleton.class) {
                if(mInstance == null) {
                    mInstance = new Singleton();
                }
            }
        }
        return mInstance;
    }