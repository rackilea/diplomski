package com.henrique.dao;

import java.sql.Connection;

import javax.naming.*;
import javax.sql.*;

public class KironMySql {

    private static DataSource KironMySql = null;
    private static DataSource KironMySqlIp = null;  //This is new line for code fix, and using "KironMySqlIp" instance later in the code where connection with "KironTabelaApp" data source is needed.
    private static Context context = null;

    public static DataSource KironMySqlConn() throws Exception{
        if (KironMySql != null) {
            return KironMySql;
        }
        try{
            if(KironMySql == null){
                context = new InitialContext();
                KironMySql = (DataSource) context.lookup("KironLocal");
            }           
        }catch(Exception e){
            e.getMessage();
        }
        return KironMySql;
    }

    public static DataSource KironMySqlConnIp() throws Exception{
        if (KironMySqlIp != null) {
            return KironMySqlIp;
        }
        try{
            if(KironMySqlIp == null){
                context = new InitialContext();
                KironMySqlIp = (DataSource) context.lookup("KironTabelaApp");
            }           
        }catch(Exception e){
            e.getMessage();
        }
        return KironMySqlIp;
    }

    public static Connection KironConnection(){
        Connection conn = null;
        try{
            conn = KironMySqlConn().getConnection();
            return conn;
        }catch(Exception e){
            e.getMessage();
        }
        return conn;
    }

    public static Connection KironConnectionIp(){
        Connection conn = null;
        try{
            conn = KironMySqlConnIp().getConnection();
            return conn;
        }catch(Exception e){
            e.getMessage();
        }
        return conn;
    }

}