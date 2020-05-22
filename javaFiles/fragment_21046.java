synchronized(OracleDataSource.class){
        ods = OracleDBConnection.instance;
        if(ods == null) {
            initialize();
        }
    }