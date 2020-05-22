synchronized(OracleDataSource.class){
        if(ods == null) {
            initialize();
        }
        ods = OracleDBConnection.instance;
    }