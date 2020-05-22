public static String API_KEY;

    public static String ORDERS_URL;

    public static String TRADES_URL;

    public static String PARTICIPANTS_URL;

    public static String INDIVIDUAL_URL;

    public static String BALANCE_URL;

    public static String TRANSACTIONS_URL;

    @Value("${api.KEY}")
    public void setAPI_KEY(String API_KEY) {
        this.API_KEY = API_KEY;
    }

    @Value("${api.ORDERS_URL}")
    public void setORDERS_URL(String ORDERS_URL) {
        this.ORDERS_URL = ORDERS_URL;
    }

    @Value("${api.TRADES_URL}")
    public void setTRADES_URL(String TRADES_URL) {
        this.TRADES_URL = TRADES_URL;
    }

    @Value("${api.PARTICIPANTS_URL}")
    public void setPARTICIPANTS_URL(String PARTICIPANTS_URL) {
        this.PARTICIPANTS_URL = PARTICIPANTS_URL;
    }

    @Value("${api.INDIVIDUAL_URL}")
    public void setINDIVIDUAL_URL(String INDIVIDUAL_URL) {
        this.INDIVIDUAL_URL = INDIVIDUAL_URL;
    }

    @Value("${api.BALANCE_URL}")
    public void setBALANCE_URL(String BALANCE_URL) {
        this.BALANCE_URL = BALANCE_URL;
    }

    @Value("${api.TRANSACTIONS_URL}")
    public void setTRANSACTIONS_URL(String TRANSACTIONS_URL) {
        this.TRANSACTIONS_URL = TRANSACTIONS_URL;
    }