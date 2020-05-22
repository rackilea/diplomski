public static synchronized long getToken() {
    return TokenID;
}

public static synchronized void setToken(long id){
    TokenID = id;
}