class db {
    private int idx;
    private Connection conn;
    db(int _idx){
        idx = _idx;
    }
    Connection Connect(){
        conn = DriverManager.getConnection("jdbc:mysql://...connection string");
        return conn;
    }
    public static void main(String args[]){
       db d = new db(1);
    }
}