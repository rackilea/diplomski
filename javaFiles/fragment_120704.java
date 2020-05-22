MessageLocalDB msgDB;



String LocalDBMesage ="_chatdb.db";
        String FinalLocalDBName = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + LocalDBMesage;
        msgDB= MessageLocalDB.getInstance(MainActivity.this,FinalLocalDBName);